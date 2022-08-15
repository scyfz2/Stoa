package com.nuoquan;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.nuoquan.config.COSProperties;
import com.nuoquan.utils.SpringUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //取消加载数据源自动配置
//@MapperScan(basePackages="com.nuoquan.mapper")
@ComponentScan(basePackages= {"com.nuoquan", "com.jupiter", "org.n3r.idworker"})
public class Application implements CommandLineRunner {
	
	@Autowired
	private COSProperties cosProperties;

	@Autowired
	private ApplicationContext appCtx;

	@Autowired
	private StringEncryptor EncryptorBean;
	
	@Bean
	public SpringUtil springUtil() {
		return new SpringUtil();
	}
	
	@Bean
	/**
	 * 生成腾讯COS对象储存客户端Bean
	 */
	public COSClient cosClient() {
		// 1 初始化用户身份信息（secretId, secretKey）。
		COSCredentials cred = new BasicCOSCredentials(cosProperties.getSecretId(), cosProperties.getSecretKey());
		// 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
		// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
		Region region = new Region(cosProperties.getRegion());
		ClientConfig clientConfig = new ClientConfig(region);
		// 3 生成 cos 客户端。
		System.out.println("生成 cos 客户端");
		return new COSClient(cred, clientConfig);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String...args) throws Exception{

		Environment environment = appCtx.getBean(Environment.class);

		String mysqlOriginPswd=environment.getProperty("spring.datasource.password");

		String redisOriginPswd=environment.getProperty("redis.password");

		String aliSmsOriginAk=environment.getProperty("ali.sms.access_key_secret");

		String mysqlEncryptedPswd=encrypt(mysqlOriginPswd);

		String redisEncryptedPswd=encrypt(redisOriginPswd);

		String aliSmsEncryptedAk=encrypt(aliSmsOriginAk);

		System.out.println(mysqlEncryptedPswd);
		System.out.println(redisEncryptedPswd);
		System.out.println(aliSmsEncryptedAk);


	}

	private String encrypt(String originPswd){
		return EncryptorBean.encrypt(originPswd);
	}
}
