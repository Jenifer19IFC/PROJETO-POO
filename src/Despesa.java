import java.sql.Date;

public class Despesa {
	
	private double valor;
	private String data;
	protected TipoDespesa tipoDespesa;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if(valor > 0)
			this.valor = valor;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if(data.length() > 0)
		this.data = data;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Despesa [valor=");
		builder.append(valor);
		builder.append(", data=");
		builder.append(data);
		builder.append(", tipoDespesa=");
		builder.append(tipoDespesa);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
