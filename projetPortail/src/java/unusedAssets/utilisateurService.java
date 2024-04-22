/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

import com.ourproject.portail.model.dao.UtilisateurDAO;
import com.ourproject.portail.model.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author 15146
 */
public class utilisateurService {
    private List<Utilisateur> listUtilisateur;
    Utilisateur utilisateur = new Utilisateur();
    UtilisateurDAO dao = new UtilisateurDAO();
    
    public List<Utilisateur> showAllUser() {
    listUtilisateur = dao.findAllUtilisateur();
    return listUtilisateur;
    }
    
    public Utilisateur verifierCodePMotDePasse(int codeP, String motDePasse){
    utilisateur = dao.existsByCodePAndPassword(codeP, motDePasse);
    return utilisateur;
    }
}
