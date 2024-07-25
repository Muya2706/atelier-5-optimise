package com.vehiculepark;
import java.sql.SQLException;
import java.util.Scanner;
import com.vehiculepark.classes.*;
public class GestionParcVehicules_ {
    public static void main(String[] args) {
        ParcVehicules parc = new ParcVehicules();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un véhicule");
            System.out.println("2. Supprimer un véhicule");
            System.out.println("3. Modifier un véhicule");
            System.out.println("4. Rechercher un véhicule par nom");
            System.out.println("5. Lister les véhicules par lettre");
            System.out.println("6. Afficher le nombre de véhicules");
            System.out.println("7. Afficher tous les véhicules");
            System.out.println("8. Rechercher un véhicule par ID");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            try {
                switch (choix) {
                    case 1:
                        System.out.print("Entrez l'ID du véhicule: ");
                        String id = scanner.nextLine();
                        System.out.print("Entrez le nom du véhicule: ");
                        String nom = scanner.nextLine();
                        System.out.print("Entrez le type de véhicule (Voiture, Camion, Moto): ");
                        String type = scanner.nextLine();
                        System.out.print("Entrez les attributs du véhicule: ");
                        String attributs = scanner.nextLine();
                        parc.ajouterVehicule(new Vehicule(id, nom, type, attributs));
                        break;
                    case 2:
                        System.out.print("Entrez l'ID du véhicule à supprimer: ");
                        id = scanner.nextLine();
                        parc.supprimerVehicule(id);
                        break;
                    case 3:
                        System.out.print("Entrez l'ID du véhicule à modifier: ");
                        id = scanner.nextLine();
                        System.out.print("Entrez le nouveau nom du véhicule: ");
                        nom = scanner.nextLine();
                        parc.modifierVehicule(id, nom);
                        break;
                    case 4:
                        System.out.print("Entrez le nom du véhicule à rechercher: ");
                        nom = scanner.nextLine();
                        Vehicule vehicule = parc.rechercherVehiculeParNom(nom);
                        if (vehicule != null) {
                            System.out.println(vehicule);
                        } else {
                            System.out.println("Véhicule non trouvé.");
                        }
                        break;
                    case 5:
                        System.out.print("Entrez la lettre alphabétique: ");
                        char lettre = scanner.nextLine().charAt(0);
                        parc.listerVehiculesParLettre(lettre);
                        break;
                    case 6:
                        System.out.println("Nombre de véhicules en stock: " + parc.nombreDeVehicules());
                        break;
                    case 7:
                        parc.afficherTousLesVehicules();
                        break;
                    case 8:
                        System.out.print("Entrez l'ID du véhicule à rechercher: ");
                        id = scanner.nextLine();
                        vehicule = parc.rechercherVehiculeParId(id);
                        if (vehicule != null) {
                            System.out.println(vehicule);
                        } else {
                            System.out.println("Véhicule non trouvé.");
                        }
                        break;
                    case 0:
                        System.out.println("Au revoir!");
                        break;
                    default:
                        System.out.println("Option invalide.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erreur de base de données: " + e.getMessage());
            }
        } while (choix != 0);

        scanner.close();
    }
}