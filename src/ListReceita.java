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

public class ListReceita {
	
	private List<Receita> lista = new ArrayList<Receita>();
	
	public List<Receita> getLista() {
		return lista;
	}

	public void setLista(List<Receita> lista) {
		this.lista = lista;
	}

	public void add(Receita receita) {
		lista.add(receita);
	}
	
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/receita.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Receita> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/receita.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Receita>>(){}.getType();
	    lista = new ArrayList<Receita>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}