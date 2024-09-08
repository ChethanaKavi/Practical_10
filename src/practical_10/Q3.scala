object Q3 {
  class Account(var balance: Double) {
    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
      println(s"Deposited $$${amount}. New balance: $$${balance}")
    }

    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdrawal amount must be positive")
      if (amount > balance) {
        println("Insufficient balance for withdrawal.")
      } else {
        balance -= amount
        println(s"Withdrew $$${amount}. New balance: $$${balance}")
      }
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      require(amount > 0, "Transfer amount must be positive")
      if (amount > balance) {
        println("Insufficient balance for transfer.")
      } else {
        this.withdraw(amount)
        toAccount.deposit(amount)
        println(s"Transferred $$${amount} to the other account.")
      }
    }

    def displayBalance(): Unit = {
      println(s"Current balance: $$${balance}")
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(500.0)
    val account2 = new Account(300.0)

    println("Initial Balances:")
    account1.displayBalance()
    account2.displayBalance()

    account1.deposit(200)

    account2.withdraw(100)

    account1.transfer(150, account2)

    // Display final balances
    println("Final Balances:")
    account1.displayBalance()
    account2.displayBalance()
  }
}
