package BankAccount;

class BankManager{
    private Account[] accounts;
    private int count;

    BankManager() {
        accounts = new Account[20];
    }

    public boolean addHolder(Account account) {
        if (count < accounts.length) {
            accounts[count++] = account;
            return true;
        }
        return false;
    }

    public boolean depositeMoney(int id,int amount) {
        for (int i=0;i<count;i++) {
            if (accounts[i].getAccountNumber() == id) {
                accounts[i].Deposite(amount);
                return true;
            }
        }
        return false;
    }

    public Account sendMoney(int a,int b,int amount, PaymentMethods method) {
        if (findAccount(a) == null || findAccount(b) == null) {
            return null;
        }
        else {
            if (amount > 0 && a != b) {
                if (method.pay(findAccount(a),findAccount(b),amount)) {
                    System.out.println("Done");
                }
                else {
                    System.out.println("False");
                }
            }
        }
        return findAccount(a);
    }

    public Account findAccount(int id) {
        for (int i=0;i<count;i++) {
            if (accounts[i].getAccountNumber() == id) {
                return accounts[i];
            }
        }
        return null;
    }




}