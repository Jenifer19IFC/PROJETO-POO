import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class ListTipoDespesa {
	
	private List<TipoDespesa> lista = new ArrayList<TipoDespesa>();
	
	public List<TipoDespesa> getLista() {
		return lista;
	}

	public void setLista(List<TipoDespesa> lista) {
		this.lista = lista;
	}

	public void add(TipoDespesa tipodespesa) {
		lista.add(tipodespesa);
	}
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/tipoDespesa.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<TipoDespesa> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/tipoDespesa.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<TipoDespesa>>(){}.getType();
	    lista = new ArrayList<TipoDespesa>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}