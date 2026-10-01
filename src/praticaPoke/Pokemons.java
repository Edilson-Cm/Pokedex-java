package praticaPoke;

public class Pokemons {
    private String nome;
    private int id;
    private int ordem;
    private int altura;
    private int peso;
    private int experiencia;
    private int abilidades;


    public Pokemons(PokeRecord meuPokemon) {
        this.nome = meuPokemon.name();
        this.id = meuPokemon.id();
        this.ordem = meuPokemon.order();
        this.altura = meuPokemon.height();
        this.experiencia = meuPokemon.base_experience();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAbilidades() {
        return abilidades;
    }

    public void setAbilidades(int abilidades) {
        this.abilidades = abilidades;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getPeso() {
        return peso;
    }


    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Seu Pokemon: "+nome+
                "\nCodigo: "+id+
                "\nOrdem: "+ordem+
                "\nPeso: "+peso+
                "\nAltura: "+altura+
                "\nEXP: "+experiencia;
    }
}
