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

public class ListDespesa {
	
	private List<Despesa> lista = new ArrayList<Despesa>();
	
	public List<Despesa> getLista() {
		return lista;
	}

	public void setLista(List<Despesa> lista) {
		this.lista = lista;
	}

	public void add(Despesa despesa) {
		lista.add(despesa);
	}
	
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/despesa.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Despesa> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/despesa.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Despesa>>(){}.getType();
	    lista = new ArrayList<Despesa>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}