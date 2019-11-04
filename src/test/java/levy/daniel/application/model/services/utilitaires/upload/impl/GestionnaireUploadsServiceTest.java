package levy.daniel.application.model.services.utilitaires.upload.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * CLASSE GestionnaireUploadsServiceTest :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 2 nov. 2019
 *
 */
public class GestionnaireUploadsServiceTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";

	/**
	 * "src/test/resources/jeux_essai".
	 */
	public static final String CHEMIN_REPERTOIRE 
		= "src/test/resources/jeux_essai";
	
	/**
	 * "Liste des fichiers sous le répertoire : ".
	 */
	public static final String LISTE_FICHIERS_SOUS_REPERTOIRE 
		= "Liste des fichiers sous le répertoire : ";
		
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings(UNUSED)
	private static final Log LOG 
		= LogFactory.getLog(GestionnaireUploadsServiceTest.class);

	// *************************METHODES************************************/
		   
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public GestionnaireUploadsServiceTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * <p>teste la méthode 
	 * <code>recupererListeFichiersSousRepertoire(Path pPath)</code>.</p>
	 * 
	 * @throws IOException 
	 */
	@SuppressWarnings(UNUSED)
    @Test
	public void testRecupererListeFichiersSousRepertoire() throws IOException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE GestionnaireUploadsServiceTest - méthode testRecupererListeFichiersSousRepertoire() ********** ");
		}
		
		// VALEURS A TESTER **********************************************
		final Path repertoire1 = Paths.get(CHEMIN_REPERTOIRE);
		// ***************************************************************
		
		// METHODE A TESTER *************************************************
		final List<String> resultat 
			= GestionnaireUploadsService // NOPMD by dan on 02/11/19 23:05
				.recupererListeFichiersSousRepertoire(repertoire1);
		// ******************************************************************
		
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(LISTE_FICHIERS_SOUS_REPERTOIRE + '\n' + GestionnaireUploadsService.afficherListeString(resultat)); // NOPMD by dan on 02/11/19 23:06
		}

	} // Fin de testRecupererListeFichiersSousRepertoire().________________

	
	
} // FIN DE LA CLASSE GestionnaireUploadsServiceTest.------------------------
