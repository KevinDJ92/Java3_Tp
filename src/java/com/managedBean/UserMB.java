package com.managedBean;

import java.io.File;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;

@ManagedBean
@ViewScoped
public class UserMB implements Serializable{
     //le chemin qu on va utiliser dans la page web
    private String chemin;
    //le path ou se trouve l application
    private String cheminApp = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    //le repertoire ou on met toutes les photos
    private String pathPhoto = "photos\\";
    
   @PostConstruct
   public void init() {
    }
    public UserMB() {
        
    }
    
    public void actionMethode(){
     FacesMessage msg = new FacesMessage("Inscription reussie");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getChemin() {
        return chemin;
    }
    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
      //notre methode listeneur pour uploader le fichier sur le serveur
    public void uploadFileMembre(FileEntryEvent ev) {
        System.out.println("////// Path :" + cheminApp);
        
        File fichier = null;
        //mettre la main sur le fileEntry (composant ace)
        FileEntry fiE = (FileEntry) ev.getSource();
        //récupérer ses resultats 
        FileEntryResults fr = fiE.getResults();

        //boucler sur les FileInfo de chaque fichier
        for (FileEntryResults.FileInfo fi : fr.getFiles()) {
            System.out.println("cheminApp : " + cheminApp);
            //s'assurer que le fichier est enregistrer
            if (fi.isSaved()) {

                //recu le fichier et le sauvegarde dans un fichier pour pouvoir le manipuler
                fichier = fi.getFile();

		 //TODO verifier que c'est le bon type de fichier 
                 //vou pourriez utiliser fi.getContentType()
                 
                //renommer le fichier
                try {                        
                    //renomme le fichier pour eviter les doublons 
                    // vous pourriez verifier si ce fichier existe deja ou pas        
                    String newFileName = ((int) (Math.random() * 100)) + fi.getFileName();

                    //methode pour ajouter le fichier sur le serveur, renvoie un boolean pour dire si ca a fonctionnéé ou pas
                    //ps pour voir les photos ajoutées aller dans le WorkSpace de votre projet, repertoire web et photos
                    boolean ren = fichier.renameTo(new File(cheminApp + pathPhoto + newFileName));

                    if (ren) {
                        //on a reussi a mettre le fichier sur le serveur, on copie le chemin pour pouvoir l afficher
                        // PS si vous deviez sauvegarder ca dans la base de donnée je pense que ca devrait se faire par la.
                        this.chemin = pathPhoto + newFileName;
                       
                        System.out.println("chemin : " + chemin);
                    } else {
                        System.out.println("pas possible. " + chemin);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    } 
}
