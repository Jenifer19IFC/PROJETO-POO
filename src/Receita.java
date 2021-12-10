import java.sql.Date;

public class Receita {
	
	private double valor;
	private String data;
	protected TipoReceita tipoReceita;
	
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
	
	
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}
	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Receita [valor=");
		builder.append(valor);
		builder.append(", data=");
		builder.append(data);
		builder.append(", tipoReceita=");
		builder.append(tipoReceita);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
		
}
