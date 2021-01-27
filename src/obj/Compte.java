package obj;

public class Compte {
    private String numero;
    private int solde;

    public Compte(){  
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Compte(String numero, int solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public void deposer(int depot) {
        solde = solde + depot;

    }
    public void retirer(int retrait){
        solde = solde - retrait;
    }
    
    public String infos(){
        String info = "Le solde du compte " + numero + " est de " + solde + " euros.";
        return info;
    }
    
    public int getSolde(){
        return solde;
    }
    
    public void virement( Compte compte2, int retrait){
        this.retirer(retrait);
        compte2.deposer(retrait);
    }
}
