package com.nuoquan.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nuoquan.mapper.nq1.TagsMapper;
import com.nuoquan.pojo.Tags;
import com.nuoquan.utils.StringUtils;

import cn.hutool.core.collection.CollectionUtil;
import tk.mybatis.mapper.entity.Example;

@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private Sid        sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Tags> getTagsList(String keyWord) {
        if (StringUtils.isNotEmpty(keyWord)) {
            Example example = new Example(Tags.class);
            example.createCriteria().andLike("tag", '%' + keyWord + '%');
            return tagsMapper.selectByExample(example);
        }
        return tagsMapper.selectAll();
    }

    @Override
    public void checkAndSaveTags(String tags) {
        Stream.of(tags.split("#")).filter(Objects::nonNull).forEach(x -> {
            Tags temp = new Tags();
            temp.setTag(x);
            if (CollectionUtil.isEmpty(tagsMapper.select(temp))) {
                temp.setId(sid.nextShort());
                tagsMapper.insert(temp);
            }
        });
    }
}
