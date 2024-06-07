package com.bao;

import com.bao.transaction.TransactionService;
import com.sun.xml.internal.xsom.parser.AnnotationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages={"com.bao.transaction"})
@EnableTransactionManagement
public class TransactionApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TransactionApplication.class,args);
        TransactionService service = (TransactionService) context.getBean("transactionService");
        service.saveUser();

    }
}
