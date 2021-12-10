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

public class ListEndereco {
	
	private List<Endereco> lista = new ArrayList<Endereco>();
	
	public List<Endereco> getLista() {
		return lista;
	}

	public void setLista(List<Endereco> lista) {
		this.lista = lista;
	}

	public void add(Endereco endereco) {
		lista.add(endereco);
	}
	
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/endereco.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Endereco> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/endereco.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Endereco>>(){}.getType();
	    lista = new ArrayList<Endereco>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}