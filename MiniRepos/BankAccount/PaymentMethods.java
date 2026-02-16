package BankAccount;
interface PaymentMethods {
    boolean pay(Account accountFrom, Account accountTo, int amount);
}

class UPI implements PaymentMethods {
    @Override
    public boolean pay(Account accountFrom, Account accountTo, int amount) {
        int fee = 0;
        int cashback = accountFrom.calculateCashback(amount);
        int totalDedution = amount + fee - cashback;
        if (accountFrom.getBalance() < totalDedution) {
            return false;
        }
        accountFrom.Withdraw(totalDedution);
        accountTo.Deposite(amount);
        return true;
    }
}

class CreditCard implements PaymentMethods {
    @Override
    public boolean pay(Account accountFrom, Account accountTo, int amount) {
        int fee = 5;
        int cashback = accountFrom.calculateCashback(amount);
        int totalDedution = amount + fee - cashback;
        if (accountFrom.getBalance() < totalDedution) {
            return false;
        }
        accountFrom.Withdraw(totalDedution);
        accountTo.Deposite(amount);
        return true;
    }
}

class NetBanking implements PaymentMethods {
        @Override
        public boolean pay(Account accountFrom, Account accountTo, int amount) {
            int fee = 10;
            int cashback = accountFrom.calculateCashback(amount);
            int totalDedution = amount + fee - cashback;
            if (accountFrom.getBalance() < totalDedution) {
                return false;
            }
            accountFrom.Withdraw(totalDedution);
            accountTo.Deposite(amount);
            return true;
    }
}