
public class Gerencial {
	
	private ListConta cl;

	public Gerencial() {
		cl = new ListConta();
	}
	
	public ListConta getCl() {
		return cl;
	}

	public void setCl(ListConta cl) {
		this.cl = cl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gerencial [cl=");
		builder.append(cl);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	

	

}
