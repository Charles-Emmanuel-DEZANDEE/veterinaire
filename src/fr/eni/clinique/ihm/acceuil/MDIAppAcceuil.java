package fr.eni.clinique.ihm.acceuil;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.ihm.log.LogInController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MDIAppAcceuil extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static MDIAppAcceuil instance;


    private JDesktopPane desktopPane;
    private JMenuBar menuBarre;

    private MDIAppAcceuil(int cas) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        // initialiser l'ecran MDI
        desktopPane = new JDesktopPane();

        // Associer le JDesktopPane à la JFrame
        setContentPane(desktopPane);

        // Barre de menus
        setJMenuBar(getMenuBarre(cas));


    }

    //singleton
    public static synchronized MDIAppAcceuil getInstance(int cas) throws DALException, BLLException {
        if (instance == null) {
            instance = new MDIAppAcceuil(cas);
        }
        return instance;
    }


    public void init(int cas) throws BLLException, DALException {
        MDIAppAcceuil ecran = MDIAppAcceuil.getInstance(cas);
        ecran.setVisible(true);
    }


    public void createMenuBar(int cas) {

        // Menu Fichier
        JMenu menuFichier = new JMenu("Fichier");
        menuBarre.add(menuFichier);

        // Sous menu Déconnexion
        JMenuItem menuItemDeco = new JMenuItem("Déconnexion");
        menuItemDeco.setActionCommand("deconnexion");
        menuItemDeco.addActionListener(this);
        menuFichier.add(menuItemDeco);

        // Sous menu fermer
        JMenuItem menuItemFermer = new JMenuItem("Fermer");
        menuItemFermer.setActionCommand("fermer");
        menuItemFermer.addActionListener(this);
        menuFichier.add(menuItemFermer);

        switch (cas) {

            // Menu Gestion secretaire
            case 1:
            JMenu menuGestion = new JMenu("Gestion des rendez-vous");
            menuBarre.add(menuGestion);

            // Sous menu Prise de rendez-vous
            JMenuItem menuItemPriseRDV = new JMenuItem("Prise de rendez-vous");
            menuItemPriseRDV.setActionCommand("priseRDV");
            menuItemPriseRDV.addActionListener(this);
            menuGestion.add(menuItemPriseRDV);

            // Sous menu Gestion des clients
            JMenuItem menuItemGestCli = new JMenuItem("Gestion des clients");
            menuItemGestCli.setActionCommand("gestionCli");
            menuItemGestCli.addActionListener(this);
            menuGestion.add(menuItemGestCli);
                break;


            // Menu véto agenda
            case 2:
            JMenu menuAgenda = new JMenu("Gestion des agendas");
            menuBarre.add(menuAgenda);

            JMenuItem menuAgendaVeto = new JMenuItem("Agenda");
            menuAgenda.add(menuAgendaVeto);
            menuAgendaVeto.setActionCommand("agenda");
            menuAgendaVeto.addActionListener(this);
                break;

            // Menu gestion du personnel admin
            case 3:

            JMenu menuPersonnel = new JMenu("Gestion du personnel ");
            menuBarre.add(menuPersonnel);


            JMenuItem menuPersonnelGestion = new JMenuItem("Le personnel");
            menuPersonnel.add(menuPersonnelGestion);
            menuPersonnelGestion.setActionCommand("gestPerso");
            menuPersonnelGestion.addActionListener(this);
                break;

        }


    }

    // Réagir aux clicks sur les menus
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "deconnexion":
                //on ferme la fenetre
                setVisible(false);
                //retour au login
                try {
                    LogInController.getInstance().getFenetreLogIn().reconnexion();
                } catch (BLLException e1) {
                    e1.printStackTrace();
                } catch (DALException e1) {
                    e1.printStackTrace();
                }
                System.out.println("Deconnexion");

                break;
            case "fermer":
                System.out.println("fermer");
                System.exit(0);
                break;
            case "priseRDV":
                System.out.println("priseRDV");
                break;
            case "gestionCli":
                System.out.println("gestionCli");
                break;
            case "agenda":
                System.out.println("agenda");
                break;
            case "gestPerso":
                System.out.println("gestPerso");
                break;

            default:
                System.out.println("Probleme e=" + e);
        }

    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JMenuBar getMenuBarre(int cas) {
        if (menuBarre == null) {
            menuBarre = new JMenuBar();

            createMenuBar(cas);
        }
        return menuBarre;
    }


}
