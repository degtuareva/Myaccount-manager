package product.star.account.manager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AccountManagerMain {
    public static void main(String[] args) {

        var applicationContext=
                new AnnotationConfigApplicationContext(AccountManagerConfig.class);

        var phoneToCardResolver=
                applicationContext.getBean(PhoneToAccountResolver.class);

        var accountService=
                applicationContext.getBean(AccountService.class);

        Account account1=new Account(1,10000L);
        Account account2=new Account(2,200L);
        System.out.println(account1);

        var phoneNumber="12345";
        phoneToCardResolver.addMapping(phoneNumber,account2);
        accountService.transferByPhoneNumber(account1,phoneNumber,1000L);

        System.out.println(account1);
        System.out.println(account2);

        accountService.transfer(account1,account2,250L);
        System.out.println(account1);
        System.out.println(account2);


    }
}
