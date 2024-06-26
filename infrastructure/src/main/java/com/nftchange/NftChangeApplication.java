package com.nftchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableAsync
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class NftChangeApplication {

	private static final Logger log = LoggerFactory.getLogger(NftChangeApplication.class);


	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(NftChangeApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("Access URLs:\n----------------------------------------------------------\n\t"
						+ "Local: \t\thttp://127.0.0.1:{}{}\n\t"
						+ "External: \thttp://{}:{}{}\n----------------------------------------------------------",
				env.getProperty("server.port"), env.getProperty("server.servlet.context-path"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
	}

}
