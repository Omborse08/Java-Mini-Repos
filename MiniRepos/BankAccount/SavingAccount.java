package BankAccount;

class SavingAccount extends Account{
    SavingAccount(String name,int number,int balance) {
        super(name,number,balance);
    }

    @Override
    String accountType() {
        return "Savings";
    }

    @Override
    int calculateCashback(int amount) {
        return 0;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String name,int number,int balance) {
        super(name,number,balance);
    }

    @Override
    String accountType() {
        return "Current";
    }

    @Override
    int calculateCashback(int amount) {
        return (int)(amount * 0.02);
    }
}

class PremiumAccount extends Account {
    PremiumAccount(String name,int number,int balance) {
        super(name,number,balance);
    }


    @Override
    String accountType() {
        return "Premium";
    }

    @Override
    int calculateCashback(int amount) {
        return (int)(amount * 0.05);
    }
}
