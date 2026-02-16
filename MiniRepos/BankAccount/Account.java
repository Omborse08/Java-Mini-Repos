package BankAccount;

abstract class Account {
    private int accountNumber;
    private String accountHolderName;
    private int balance;

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history[count++] = history;
    }

    private String[] history;
    private int count;


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    Account(String name,int accountNumber, int balance) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        history = new String[100];
    }

    public boolean Deposite(int amount) {
        if (amount > 0) {
            this.balance += amount;
            if (count < history.length) {
                history[count++] = " <- Balance Added!: "+amount;
            }
            return true;
        }
        return false;
    }

    public boolean Withdraw(int amount) {
        if (amount <= balance && amount > 0) {
            this.balance -= amount;
            if (count < history.length) {
                history[count++] = " <- Balance Withdrawed: "+amount;
            }
            return true;
        }
        return false;
    }

    abstract String accountType();

    abstract int calculateCashback(int amount);

    public int getBalance() {
        return balance;
    }
}
