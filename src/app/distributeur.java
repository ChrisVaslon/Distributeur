
package app;
import obj.DAB;
import java.io.IOException;
import obj.EnsembleComptes;
import obj.Compte;


public class distributeur {
    public static void main(String[] args) throws IOException {
        
        Compte[] comptesUser = new Compte[2];
        comptesUser[0] = new Compte("98", 1000);
        comptesUser[1] = new Compte("99", 2000);
        
        DAB distributeur = new DAB (comptesUser);
        
        distributeur.activer();
    }
   
}