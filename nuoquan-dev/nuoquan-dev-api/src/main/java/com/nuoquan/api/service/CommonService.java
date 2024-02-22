package com.nuoquan.api.service;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.nuoquan.admin.controller.BeanCopyUtils.map;
import static com.nuoquan.admin.controller.BeanCopyUtils.mapBy;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuoquan.controller.BasicController;
import com.nuoquan.pojo.*;
import com.nuoquan.pojo.vo.LeaderBoardEvaluateVO;
import com.nuoquan.pojo.vo.LeaderBoardObjectVO;
import com.nuoquan.pojo.vo.LeaderBoardVO;
import com.nuoquan.service.*;

/**
 * CommonService
 *
 * @author xxdd
 * @date 2024-01-14 19:50
 */
@Service
public class CommonService extends BasicController {

    @Autowired
    private LeaderBoardService             leaderBoardService;

    @Autowired
    private LeaderBoardObjectService       leaderBoardObjectService;

    @Autowired
    private LeaderBoardTagService          leaderBoardTagService;

    @Autowired
    private LeaderBoardEvaluateService     leaderBoardEvaluateService;

    @Autowired
    private LeaderBoardEvaluateStarService leaderBoardEvaluateStarService;

    @Autowired
    private UserService                    userService;

    @Value("${leaderBoard.approval.auto}")
    private boolean                        approvalFlag;

    public void addEvaluateCount(Long leaderBoardObjectId) {
        LeaderBoardObject leaderBoardObject = leaderBoardObjectService.selectByPrimaryKey(leaderBoardObjectId.toString());
        leaderBoardObject.setEvaluateNums(leaderBoardObject.getEvaluateNums() == null ? 1 : leaderBoardObject.getEvaluateNums() + 1);
        leaderBoardObjectService.updateVisible(leaderBoardObject);
        LeaderBoard leaderBoard = leaderBoardService.selectByPrimaryKey(leaderBoardObject.getLeaderBoardId().toString());
        leaderBoard.setEvaluateNums(leaderBoard.getEvaluateNums() == null ? 1 : leaderBoard.getEvaluateNums() + 1);
        leaderBoardService.updateVisible(leaderBoard);
    }

    public boolean checkStar(Long evaluateId, String userId) {
        LeaderBoardEvaluateStarExample example = new LeaderBoardEvaluateStarExample();
        example.createCriteria().andEvaluateIdEqualTo(evaluateId).andUserIdEqualTo(userId);
        List<LeaderBoardEvaluateStar> leaderBoardEvaluateStars = leaderBoardEvaluateStarService.selectByExample(example);
        return leaderBoardEvaluateStars.isEmpty();
    }

    public void addStarNum(Long evaluateId) {
        if (evaluateId == null) {
            return;
        }
        LeaderBoardEvaluate leaderBoardEvaluate = leaderBoardEvaluateService.selectByPrimaryKey(evaluateId.toString());
        leaderBoardEvaluate.setStarNum(leaderBoardEvaluate.getStarNum() == null ? 1 : leaderBoardEvaluate.getStarNum() + 1);
        leaderBoardEvaluateService.updateVisible(leaderBoardEvaluate);
    }

    public void removeStarNum(Long evaluateId) {
        if (evaluateId == null) {
            return;
        }
        LeaderBoardEvaluate leaderBoardEvaluate = leaderBoardEvaluateService.selectByPrimaryKey(evaluateId.toString());
        leaderBoardEvaluate.setStarNum(leaderBoardEvaluate.getStarNum() == null ? 0 : leaderBoardEvaluate.getStarNum() == 0 ? 0 : leaderBoardEvaluate.getStarNum() - 1);
        leaderBoardEvaluateService.updateVisible(leaderBoardEvaluate);
    }

    /**
     * 榜单首页展示的榜单组件包含三个评分人数最多的评分对象，以及对应的三个人数最多的评论。
     * 
     * @param leaderBoardId
     */
    public List<LeaderBoardObjectVO> topThreeObject(Long leaderBoardId) {
        LeaderBoardObjectExample example = new LeaderBoardObjectExample();
        LeaderBoardObjectExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardIdEqualTo(leaderBoardId);
        // 审核通过
        criteria.andStatusEqualTo("2");
        startPage(1, 3);
        List<LeaderBoardObject> leaderBoardObjects = leaderBoardObjectService.selectByExample(example);
        List<LeaderBoardObjectVO> leaderBoardObjectVOS = mapBy(leaderBoardObjects, x -> map(x, LeaderBoardObjectVO.class));
        leaderBoardObjectVOS.forEach(x -> {
            x.setLeaderBoardEvaluateList(topEvaluate(x.getId()));
        });
        return leaderBoardObjectVOS;
    }

    /**
     * 前3评论
     * 
     * @param leaderBoardObjectId
     */
    public List<LeaderBoardEvaluateVO> topEvaluate(Long leaderBoardObjectId) {
        LeaderBoardEvaluateExample example = new LeaderBoardEvaluateExample();
        LeaderBoardEvaluateExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardObjectIdEqualTo(leaderBoardObjectId);
        example.setOrderByClause("star_num desc");
        startPage(1, 1);
        List<LeaderBoardEvaluate> leaderBoardEvaluates = leaderBoardEvaluateService.selectByExample(example);
        return mapBy(leaderBoardEvaluates, x -> map(x, LeaderBoardEvaluateVO.class));
    }

    public boolean checkEvaluate(Long leaderBoardObjectId, String userId) {
        LeaderBoardEvaluateExample example = new LeaderBoardEvaluateExample();
        LeaderBoardEvaluateExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardObjectIdEqualTo(leaderBoardObjectId);
        criteria.andUserIdEqualTo(userId);
        List<LeaderBoardEvaluate> leaderBoardEvaluates = leaderBoardEvaluateService.selectByExample(example);
        return leaderBoardEvaluates.isEmpty();
    }

    public Map<Integer, String> starMap(Long leaderBoardObjectId) {
        LeaderBoardEvaluateExample example = new LeaderBoardEvaluateExample();
        LeaderBoardEvaluateExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardObjectIdEqualTo(leaderBoardObjectId);
        List<LeaderBoardEvaluate> leaderBoardList = leaderBoardEvaluateService.selectByExample(example);
        // 初始化分组统计的 Map
        Map<Integer, Integer> groupCountMap = new HashMap<>();
        int totalCount = 0;

        // 遍历对象列表，统计每个分组的数量
        for (LeaderBoardEvaluate item : leaderBoardList) {
            BigDecimal star = item.getStar();
            int group = star.intValue(); // 取整数部分作为分组
            groupCountMap.put(group, groupCountMap.getOrDefault(group, 0) + 1);
            totalCount++;
        }

        // 计算百分比并存储结果的 Map [1,2,3,4,5,6,7,8,9]
        Map<Integer, String> result = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            // 0 1 2 3 4
            int count = groupCountMap.getOrDefault(i * 2 + 1, 0);
            int count1 = groupCountMap.getOrDefault(i * 2 + 2, 0);
            double percentage = (double) (count + count1) / totalCount * 100;
            percentage = Double.isNaN(percentage) ? 0 : percentage;
            result.put(i, String.format("%.2f", percentage) == null ? "0" : String.format("%.2f", percentage));
        }
        return result;
    }

    public void averageStar(Long leaderBoardObjectId) {
        LeaderBoardEvaluateExample example = new LeaderBoardEvaluateExample();
        LeaderBoardEvaluateExample.Criteria criteria = example.createCriteria();
        criteria.andLeaderBoardObjectIdEqualTo(leaderBoardObjectId);
        List<LeaderBoardEvaluate> leaderBoardList = leaderBoardEvaluateService.selectByExample(example);
        BigDecimal sum = new BigDecimal(0);
        for (LeaderBoardEvaluate item : leaderBoardList) {
            sum = sum.add(item.getStar());
        }
        BigDecimal divide = sum.divide(new BigDecimal(leaderBoardList.size()), 2, BigDecimal.ROUND_HALF_UP);
        LeaderBoardObject leaderBoardObject = leaderBoardObjectService.selectByPrimaryKey(String.valueOf(leaderBoardObjectId));
        if (leaderBoardObject == null) {
            return;
        }
        leaderBoardObject.setStar(divide);
        leaderBoardObjectService.updateVisible(leaderBoardObject);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertLeaderBoard(LeaderBoardVO leaderBoard) {
        // 审核中
        leaderBoard.setStatus("1");
        if (approvalFlag) {
            leaderBoard.setStatus("2");
        }
        leaderBoard.setCreateTime(new Date());
        LeaderBoard map = map(leaderBoard, LeaderBoard.class);
        int i = leaderBoardService.insertSelective(map);
        LeaderBoardExample example = new LeaderBoardExample();
        LeaderBoardExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(leaderBoard.getName());
        List<LeaderBoard> leaderBoards = leaderBoardService.selectByExample(example);
        LeaderBoard res = leaderBoards.get(0);

        leaderBoard.getLeaderBoardObjectList().forEach(x -> {
            x.setLeaderBoardId(res.getId());
            x.setCreateTime(new Date());
            x.setCreateBy(res.getCreateBy());
            x.setStatus("2");
            leaderBoardObjectService.insertSelective(x);
        });
        return i;
    }

}
