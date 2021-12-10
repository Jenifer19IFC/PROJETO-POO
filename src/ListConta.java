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

public class ListConta {
	
	private List<Conta> lista = new ArrayList<Conta>();
	
	public List<Conta> getLista() {
		return lista;
	}

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}

	public void add(Conta conta) {
		lista.add(conta);
	}
	
	
	public void gravar() {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("json/conta.json");
			writer.write(gson.toJson(lista));
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Conta> ler() {
	    BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
							 new FileReader("json/conta.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    Type listType = new TypeToken<ArrayList<Conta>>(){}.getType();
	    lista = new ArrayList<Conta>();
	    lista = new Gson().fromJson(bufferedReader, listType);
	    return lista;
	}

}