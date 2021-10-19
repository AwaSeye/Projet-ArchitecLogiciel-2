package core;

import service.UserManager;
import service.UserManagerService;
import service.Utilisateur;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionUser
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        UserManager stub = new UserManagerService().getUserManagerPort();


        System.out.println("Entrer login");
        String loginConnect = sc.next();

        System.out.println("Entrer password");
        String passwordConnect = sc.next();

        ArrayList<Utilisateur> utilisateursConnect = (ArrayList<Utilisateur>) stub.lister();
        for (int j =0; j<utilisateursConnect.size(); j++)
        {
            if (loginConnect.equals(utilisateursConnect.get(j).getLogin()) && passwordConnect.equals(utilisateursConnect.get(j).getPassword()) )
            {
                System.out.println("Login et Mot de passe corrects !!");
                System.out.println("\n");
                System.out.println("Appuyez sur la lettre C pour continuer [c = continuer]");
                String choix = sc.next();
                while(choix != "q")
                {
                    System.out.println("Choisissez une lettre [a-m-s-l-q]: [a = ajouter | m = modifier | s = supprimer | l = lister | q = quitter]");
                    choix = sc.next();
                    switch (choix)
                    {
                        case "a":
                            System.out.println("Entrer nom");
                            String nom = sc.next();

                            System.out.println("Entrer prenom");
                            String prenom = sc.next();

                            System.out.println("Entrer login");
                            String login = sc.next();

                            System.out.println("Entrer password");
                            String password = sc.next();

                            stub.ajouter(nom, prenom, login, password);

                            System.out.println("\n");

                            System.out.println("Description de l'utilisateur\n");
                            System.out.printf("Nom:       %s\n" +
                                    "Prenom:    %s \n" +
                                    "Login:     %s \n" +
                                    "Password:  %s\n", nom, prenom, login, password);
                            break;

                        case "m":
                            System.out.println("Entrer l'ID à modifier");
                            int id0 = sc.nextInt();
                            ArrayList<Utilisateur> utilisateursModifier = (ArrayList<Utilisateur>) stub.lister();
                            for (int m = 0; m < utilisateursModifier.size(); m++) {
                                if (id0 == utilisateursModifier.get(m).getId()) {
                                    System.out.println("Entrer nom");
                                    String nom1 = sc.next();

                                    System.out.println("Entrer prenom");
                                    String prenom1 = sc.next();

                                    System.out.println("Entrer login");
                                    String login1 = sc.next();

                                    System.out.println("Entrer password");
                                    String password1 = sc.next();

                                    stub.modifier(id0, nom1, prenom1, login1, password1);

                                    System.out.println("\n");
                                    System.out.println("Modification avec succes de l'ID : " + utilisateursModifier.get(m).getId());

                                    System.out.println("Description de l'utilisateur\n");
                                    System.out.printf("ID:       %d\n" +
                                            "Nom:       %s\n" +
                                            "Prenom:    %s \n" +
                                            "Login:     %s \n" +
                                            "Password:  %s\n", id0, nom1, prenom1, login1, password1);
                                }
//                                else {
//                                    System.out.println("Cet utilisateur n'existe pas !!\n");
//                                }
                            }
                            break;

                        case "s":
                            System.out.println("Entrer l'ID à supprimer");
                            int id1 = sc.nextInt();
                            ArrayList<Utilisateur> utilisateursSupprimer = (ArrayList<Utilisateur>) stub.lister();
                            for (int s = 0; s < utilisateursSupprimer.size(); s++) {
                                if (id1 == utilisateursSupprimer.get(s).getId()) {

                                    stub.supprimer(id1);

                                    System.out.println("\n");
                                    System.out.println("Suppression avec succes de l'ID : " + utilisateursSupprimer.get(s).getId());
                                }
//                                else
//                            {
//                                System.out.println("Cet utilisateur n'existe pas !!\n");
//                            }
                            }
                            break;

                        case "l":
                            ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) stub.lister();
                            for (int i = 0; i < utilisateurs.size(); i++) {
                                System.out.println("ID: " + utilisateurs.get(i).getId());
                                System.out.println("Nom: " + utilisateurs.get(i).getNom());
                                System.out.println("Prenom: " + utilisateurs.get(i).getPrenom());
                                System.out.println("Login: " + utilisateurs.get(i).getLogin());
                                System.out.println("Password: " + utilisateurs.get(i).getPassword());
                                System.out.println("\n");
                            }

                            break;

                        case "q":
                            return;

                        default:
                            System.out.println("Vous avez fait un mauvais choix !!");
                    }
                }
            }
            else
            {
                System.out.println("Login ou Mot de passe incorrect!!");
            }
        }
    }
}
