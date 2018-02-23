package prob03;

public class Money {

	private int amount;
    
    public Money() {}

	public Money(int amount) {
		super();
		this.amount = amount;
	}

	public Money add(Money addData) {
		//this.amount += addData.amount;
		return new Money(addData.amount + this.amount);
	}

	public Money minus(Money minusData) {
		//this.amount -= minusData.amount;
		return new Money(this.amount - minusData.amount);
	}

	public Money multiply(Money mulData) {
		//this.amount *= mulData.amount;
		return new Money(this.amount * mulData.amount);
	}

	public Money devide(Money devData) {
		if(devData.amount == 0)
			System.out.println("0으로 안나눠지는거 알죠?? ㅎㅎ");
		//this.amount /= devData.amount;
		return new Money(this.amount / devData.amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount != other.amount)
			return false;
		return true;
	}
}
