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

public class ListTipoReceita {
	
	private List<TipoReceita> lista = new ArrayList<TipoReceita>();
	
	public List<TipoReceita> getLista() {
		return lista;
	}

	public void setLista(List<TipoReceita> lista) {
		this.lista = lista;
	}

	public void add(TipoReceita tiporeceita) {
		lista.add(tiporeceita);
	}
	
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/tipoReceita.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<TipoReceita> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/tipoReceita.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<TipoReceita>>(){}.getType();
	    lista = new ArrayList<TipoReceita>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}