import org.json.*;

import java.io.*;
import java.util.Map;

public class GsonTests {
    public static void main(String[] args) {
        (new GsonTests()).crearCancion();
    }

    public void crearCancion() {
        String json = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/canciones.json"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            json = sb.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        Canciones a = new Canciones(new JSONObject(json).getJSONObject("canciones1"));
        Canciones b = new Canciones("Darkside", "Alan Walker playlist", 3, 8);
        System.out.println(b.equals(a));
    }

    public class Canciones extends JSONObject {

        // atributos
        public String nombre;
        public String album;
        public int numeroDescargas;
        public int precio;

        // constructor por defecto
        public Canciones() {
            this.nombre = "default";
            this.album = "default";
            this.numeroDescargas = 0;
            this.precio = 5;
        }

        // constructor con parametros
        public Canciones(String nombre, String album, int numeroDescargas, int precio) {
            setNombre(nombre);
            setAlbum(album);
            setNumeroDescargas(numeroDescargas);
            setPrecio(precio);
        }

        public Canciones (JSONObject canciones) {
            this.nombre = canciones.getString("nombre");
            this.album = canciones.getString("album");
            this.numeroDescargas = canciones.getInt("numeroDescargas");
            this.precio = canciones.getInt("precio");
        }

        // metodos
        private void setNombre(String nombre) {
            this.nombre = nombre;
        }

        private void setAlbum(String album) {
            this.album = album;
        }

        private void setNumeroDescargas(int numeroDescargas) {
            this.numeroDescargas = numeroDescargas;
        }

        private void setPrecio(int precio) {
            this.precio = precio;
        }

        public boolean equals(Canciones object) {
                return (this.precio == object.precio);
        }

    }
}

