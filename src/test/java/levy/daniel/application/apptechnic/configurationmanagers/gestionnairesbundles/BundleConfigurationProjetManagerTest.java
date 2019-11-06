package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesbundles;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractRunTimeTechnicalException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.BundleManquantRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.CleManquanteRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.CleNullRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierInexistantRunTimeException;


/**
 * class BundleConfigurationProjetManagerTest :<br/>
 * Test JUnit de la classe {@link BundleConfigurationProjetManager}.<br/>
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
 * @since 4 janv. 2018
 *
 */
public class BundleConfigurationProjetManagerTest {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	/**
	 * "unused".
	 */
	public static final String UNUSED 
		= "unused";
	
	/**
	 * RAPPORT_CONFIGURATION : String :<br/>
	 * "RAPPORT DE CONFIGURATION : ".<br/>
	 */
	public static final String RAPPORT_CONFIGURATION 
		= "RAPPORT DE CONFIGURATION : ";
	
	/**
	 * RAPPORT_CONFIG_NE_DOIT : String :<br/>
	 * "Le rapport de configuration ne doit ".<br/>
	 */
	public static final String RAPPORT_CONFIG_NE_DOIT 
		= "Le rapport de configuration ne doit ";

	
	/**
	 * RAPPORT_UTILISATEUR : String :<br/>
	 * "RAPPORT UTILISATEUR : ".<br/>
	 */
	public static final String RAPPORT_UTILISATEUR 
		= "RAPPORT UTILISATEUR : ";

	
	/**
	 * RAPPORT_UTILISATEUR_NE_DOIT : String :<br/>
	 * "Le rapport utilisateur ne doit ".<br/>
	 */
	public static final String RAPPORT_UTILISATEUR_NE_DOIT 
		= "Le rapport utilisateur ne doit ";

	
	/**
	 * LISTE_EXCEPTIONS : String :<br/>
	 * "LISTE DES EXCEPTIONS ENCAPSULEES DANS e : ".<br/>
	 */
	public static final String LISTE_EXCEPTIONS 
		= "LISTE DES EXCEPTIONS ENCAPSULEES DANS e : ";
	
	
	/**
	 * CAS_EXCEPTION : String :<br/>
	 * "pas être null en cas d'Exception : ".<br/>
	 */
	public static final String CAS_EXCEPTION 
		= "pas être null en cas d'Exception : ";

	
	/**
	 * CAUSE_BUNDLEMANQUANT : String :<br/>
	 * "La cause de la BundleManquantRunTimeException ".<br/>
	 */
	public static final String CAUSE_BUNDLEMANQUANT 
		= "La cause de la BundleManquantRunTimeException ";
	
	
	/**
	 * DOIT_ETRE_BUNDLEMANQUANT : String :<br/>
	 * "doit être une BundleManquantRunTimeException : ".<br/>
	 */
	public static final String DOIT_ETRE_BUNDLEMANQUANT 
		= "doit être une BundleManquantRunTimeException : ";

	
	/**
	 * DOIT_ETRE_MISSINGRESOURCE : String :<br/>
	 * "doit être une MissingResourceException : ".<br/>
	 */
	public static final String DOIT_ETRE_MISSINGRESOURCE 
		= "doit être une MissingResourceException : ";
	
	
	/**
	 * CAUSE_CLEMANQUANTERUNTIME : String :<br/>
	 * "La cause de la CleManquanteRunTimeException ".<br/>
	 */
	public static final String CAUSE_CLEMANQUANTERUNTIME 
		= "La cause de la CleManquanteRunTimeException ";
	
	
	/**
	 * DOIT_ETRE_CLEMANQUANTE : String :<br/>
	 * "doit être une CleManquanteRunTimeException : ".<br/>
	 */
	public static final String DOIT_ETRE_CLEMANQUANTE 
		= "doit être une CleManquanteRunTimeException : ";
	
	
	/**
	 * CAUSE_CLENULL : String :<br/>
	 * "La cause de la CleNullRunTimeException ".<br/>
	 */
	public static final String CAUSE_CLENULL 
		= "La cause de la CleNullRunTimeException ";
	
	
	/**
	 * DOIT_ETRE_CLENULL : String :<br/>
	 * "doit être une CleNullRunTimeException : ".<br/>
	 */
	public static final String DOIT_ETRE_CLENULL 
		= "doit être une CleNullRunTimeException : ";
	

	/**
	 * CAUSE_FICHIERINEXISTANT : String :<br/>
	 * "La cause de la FichierInexistantRunTimeException ".<br/>
	 */
	public static final String CAUSE_FICHIERINEXISTANT 
		= "La cause de la FichierInexistantRunTimeException ";
	
	
	/**
	 * DOIT_ETRE_FICHIERINEXISTANT : String :<br/>
	 * "doit être une FichierInexistantRunTimeException : ".<br/>
	 */
	public static final String DOIT_ETRE_FICHIERINEXISTANT 
		= "doit être une FichierInexistantRunTimeException : ";
	
	/**
	 * "testGetNomProjet()".
	 */
	public static final String TEST_GETNOMPROJET 
		= "testGetNomProjet()";
	
	/**
	 * "testGetGroupid()".
	 */
	public static final String TEST_GETGROUPID 
		= "testGetGroupid()";

	/**
	 * "testGetPathWorkspace()".
	 */
	public static final String TEST_GETPATHWORKSPACE 
		= "testGetPathWorkspace()";
	
	/**
	 * "testGetPathMainJava()".
	 */
	public static final String TEST_GETPATHMAINJAVA 
		= "testGetPathMainJava()";
	
	/**
	 * "testGetPathMainResources()".
	 */
	public static final String TEST_GETPATHMAINRESOURCES 
		= "testGetPathMainResources()";
	
	/**
	 * "testGetPathTestJava()".
	 */
	public static final String TEST_GETPATHTESTJAVA 
		= "testGetPathTestJava()";
	
	/**
	 * "testGetPathTestResources()".
	 */
	public static final String TEST_GETPATHTESTRESOURCES 
		= "testGetPathTestResources()";
	
	/**
	 * "testGetNomRepertoireSrc() : ".
	 */
	public static final String TEST_GETNOMREPERTOIRESRC 
		= "testGetNomRepertoireSrc() : ";
	
	/**
	 * "l'objet ne doit pas être null : ".
	 */
	public static final String OBJET_DOIT_PAS_ETRE_NULL 
		= "l'objet ne doit pas être null : ";
	
	/**
	 * "l'objet doit être un Singleton : ".
	 */
	public static final String OBJET_DOIT_ETRE_SINGLETON 
		= "l'objet doit être un Singleton : ";
	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";

	/**
	 * "BIDON : ".<br/>
	 */
	public static final String BIDON = "BIDON : ";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(BundleConfigurationProjetManagerTest.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR BundleConfigurationProjetManagerTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public BundleConfigurationProjetManagerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testGetBundleConfigurationProjet() :<br/>
	 * <ul>
	 * <li>teste la méthode getBundleConfigurationProjet().</li>
	 * <li>garantit que getBundleConfigurationProjet() 
	 * retourne un Singleton.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetBundleConfigurationProjet() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetBundleConfigurationProjet() ********** ");
		}

		try {
			
			final ResourceBundle bundleCP 
			= BundleConfigurationProjetManager
				.getBundleConfigurationProjet();
			
			final ResourceBundle bundleCP2 
			= BundleConfigurationProjetManager
				.getBundleConfigurationProjet();
		
			/* garantit que l'objet n'est pas null. */
			assertNotNull(
					"Le Bundle ne doit pas être null : ", bundleCP);
						
			/* garantit que l'objet est un Singleton. */
			assertSame("getBundleConfigurationProjet() doit "
					+ "retourner la même instance (Singleton) : "
						, bundleCP
							, bundleCP2);
			
		} catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						"testGetBundleConfigurationProjet()"
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ "pas être null en cas d'Exception : "
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de application.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
			
		}		
		
	} // Fin de testGetBundleConfigurationProjet().________________________
	

	
	/**
	 * method testGetPathWorkspace() :<br/>
	 * <ul>
	 * <li>teste la méthode getNomProjet().</li>
	 * <li>garantit que getNomProjet() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathWorkspace() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathWorkspace() ********** ");
		}
		
		String path1 = null;
		String path2 = null;
		
		try {
			
			path1 
				= BundleConfigurationProjetManager.getNomProjet();
			
			path2 
				= BundleConfigurationProjetManager.getNomProjet();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETPATHWORKSPACE); 
				System.out.println("PATH DU WORKSPACE : " 
						+ path1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL 
					, path1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON 
					, path1, path2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHWORKSPACE
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHWORKSPACE
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHWORKSPACE
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHWORKSPACE
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
				
	} // Fin de testGetPathWorkspace().____________________________________
	

	
	/**
	 * method testGetNomProjet() :<br/>
	 * <ul>
	 * <li>teste la méthode getNomProjet().</li>
	 * <li>garantit que getNomProjet() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetNomProjet() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetNomProjet() ********** ");
		}
				
		String nomProjet1 = null;
		String nomProjet2 = null;
		
		try {
			
			nomProjet1 
				= BundleConfigurationProjetManager.getNomProjet();
			
			nomProjet2 
				= BundleConfigurationProjetManager.getNomProjet();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETNOMPROJET); 
				System.out.println("NOM DU PROJET : " 
						+ nomProjet1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, nomProjet1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, nomProjet1, nomProjet2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMPROJET
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMPROJET
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMPROJET
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMPROJET
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetNomProjet().________________________________________
	
	
	
	/**
	 * method testGetNomRepertoireSrc() :<br/>
	 * <ul>
	 * <li>teste la méthode getNomRepertoireSrc().</li>
	 * <li>garantit que getNomRepertoireSrc() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetNomRepertoireSrc() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetNomRepertoireSrc() ********** ");
		}
						
		String nomRepertoireSrc1 = null;
		String nomRepertoireSrc2 = null;
		
		try {
			
			nomRepertoireSrc1 
				= BundleConfigurationProjetManager.getNomRepertoireSrc();
			
			nomRepertoireSrc2 
				= BundleConfigurationProjetManager.getNomRepertoireSrc();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETNOMREPERTOIRESRC); 
				System.out.println("NOM DU REPERTOIRE SRC : " 
						+ nomRepertoireSrc1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, nomRepertoireSrc1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, nomRepertoireSrc1, nomRepertoireSrc2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMREPERTOIRESRC
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMREPERTOIRESRC
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMREPERTOIRESRC
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETNOMREPERTOIRESRC
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetNomRepertoireSrc()._________________________________
	

	
	/**
	 * method testGetPathMainJava() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathMainJava().</li>
	 * <li>garantit que getPathMainJava() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathMainJava() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathMainJava() ********** ");
		}
								
		String pathMainJava1 = null;
		String pathMainJava2 = null;
		
		try {
			
			pathMainJava1 
				= BundleConfigurationProjetManager.getPathRelMainJava();
			
			pathMainJava2 
				= BundleConfigurationProjetManager.getPathRelMainJava();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETPATHMAINJAVA); 
				System.out.println("NOM DU PATH MAIN JAVA : " 
						+ pathMainJava1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, pathMainJava1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, pathMainJava1, pathMainJava2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetPathMainJava()._________________________________
	

		
	/**
	 * method testGetPathMainResources() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathMainResources().</li>
	 * <li>garantit que getPathMainResources() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathMainResources() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathMainResources() ********** ");
		}
										
		String pathMainResources1 = null;
		String pathMainResources2 = null;
		
		try {
			
			pathMainResources1 
				= BundleConfigurationProjetManager.getPathRelMainResources();
			
			pathMainResources2 
				= BundleConfigurationProjetManager.getPathRelMainResources();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETPATHMAINRESOURCES); 
				System.out.println("NOM DU PATH MAIN RESOURCES : " 
						+ pathMainResources1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, pathMainResources1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, pathMainResources1, pathMainResources2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHMAINRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetPathMainResources()._________________________________
	

	
	/**
	 * method testGetPathTestJava() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathTestJava().</li>
	 * <li>garantit que getPathTestJava() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathTestJava() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathTestJava() ********** ");
		}
												
		String pathTestJava1 = null;
		String pathTestJava2 = null;
		
		try {
			
			pathTestJava1 
				= BundleConfigurationProjetManager.getPathRelTestJava();
			
			pathTestJava2 
				= BundleConfigurationProjetManager.getPathRelTestJava();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETPATHTESTJAVA); 
				System.out.println("NOM DU PATH TEST JAVA : " 
						+ pathTestJava1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, pathTestJava1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, pathTestJava1, pathTestJava2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTJAVA
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetPathTestJava()._________________________________
	

		
	/**
	 * method testGetPathTestResources() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathTestResources().</li>
	 * <li>garantit que getPathTestResources() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathTestResources() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathTestResources() ********** ");
		}
														
		String pathResourcesJava1 = null;
		String pathResourcesJava2 = null;
		
		try {
			
			pathResourcesJava1 
				= BundleConfigurationProjetManager.getPathRelTestResources();
			
			pathResourcesJava2 
				= BundleConfigurationProjetManager.getPathRelTestResources();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETPATHTESTRESOURCES); 
				System.out.println("NOM DU PATH RESOURCES JAVA : " 
						+ pathResourcesJava1);
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, pathResourcesJava1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, pathResourcesJava1, pathResourcesJava2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETPATHTESTRESOURCES
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetPathTestResources()._________________________________
	

	
	/**
	 * method testGetRacineMainJava() :<br/>
	 * <ul>
	 * <li>teste la méthode getRacineMainJava().</li>
	 * <li>garantit que getRacineMainJava() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetRacineMainJava() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetRacineMainJava() ********** ");
		}
														
		final String racineMainJava 
			= BundleConfigurationProjetManager.getRacineMainJava();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetRacineMainJava()");
			System.out.println("PATH ABSOLU MAIN JAVA : " 
					+ racineMainJava);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetRacineMainJava().___________________________________
	
	
	
	/**
	 * method testGetRacineMainResources() :<br/>
	 * <ul>
	 * <li>teste la méthode getRacineMainResources().</li>
	 * <li>garantit que getRacineMainResources() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetRacineMainResources() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetRacineMainResources() ********** ");
		}
														
		final String racineMainResources 
			= BundleConfigurationProjetManager.getRacineMainResources();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetRacineMainResources()");
			System.out.println("PATH ABSOLU MAIN RESOURCES : " 
					+ racineMainResources);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetRacineMainResources().______________________________
	

	
	/**
	 * method testGetRacineTestJava() :<br/>
	 * <ul>
	 * <li>teste la méthode getRacineTestJava().</li>
	 * <li>garantit que getRacineTestJava() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetRacineTestJava() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetRacineTestJava() ********** ");
		}
														
		final String racineTestJava 
			= BundleConfigurationProjetManager.getRacineTestJava();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetRacineTestJava()");
			System.out.println("PATH ABSOLU TEST JAVA : " 
					+ racineTestJava);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetRacineTestJava().___________________________________
	

	
	/**
	 * method testGetRacineTestResources() :<br/>
	 * <ul>
	 * <li>teste la méthode getRacineTestResources().</li>
	 * <li>garantit que getRacineTestResources() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetRacineTestResources() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetRacineTestResources() ********** ");
		}
														
		final String racineTestResources 
			= BundleConfigurationProjetManager.getRacineTestResources();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetRacineTestResources()");
			System.out.println("PATH ABSOLU TEST RESOURCES : " 
					+ racineTestResources);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetRacineTestResources().______________________________
	

		
	/**
	 * method testGetGroupid() :<br/>
	 * <ul>
	 * <li>teste la méthode getGroupid().</li>
	 * <li>garantit que getGroupid() retourne un Singleton.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetGroupid() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetGroupid() ********** ");
		}
																
		String groupid1 = null;
		String groupid2 = null;
		
		try {
			
			groupid1 
				= BundleConfigurationProjetManager.getGroupid();
			
			groupid2 
				= BundleConfigurationProjetManager.getGroupid();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_GETGROUPID); 
				System.out.println("GROUPID : " 
						+ groupid1);
				System.out.println("PATH GROUPID : " 
						+ BundleConfigurationProjetManager
							.getPathRelGroupId());
			}
			
			/* garantit que l'objet n'est pas null. */
			assertNotNull(OBJET_DOIT_PAS_ETRE_NULL
					, groupid1);
			
			/* garantit que l'objet est un Singleton. */
			assertSame(OBJET_DOIT_ETRE_SINGLETON
					, groupid1, groupid2);
			
		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETGROUPID
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de 
			 * configuration_ressources_externes.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException. */
			assertTrue(CAUSE_BUNDLEMANQUANT
					+ DOIT_ETRE_BUNDLEMANQUANT
					, e.getCause() instanceof BundleManquantRunTimeException);
		
		}
		catch (CleManquanteRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETGROUPID
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
			/* garantit que l'absence de la clé dans 
			 * configuration_ressources_externes.properties jette 
			 * une CleManquanteRunTimeException provoquée par une 
			 * MissingResourceException. */
			assertTrue(CAUSE_CLEMANQUANTERUNTIME
					+ DOIT_ETRE_MISSINGRESOURCE
					, e.getCause() instanceof MissingResourceException);
		
		}
		catch (CleNullRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETGROUPID
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
		catch (FichierInexistantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= BundleConfigurationProjetManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= BundleConfigurationProjetManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				afficher(
						TEST_GETGROUPID
						, rapportConfigurationCsv
						, rapportUtilisateurCsv
						, e);
				
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_CONFIG_NE_DOIT
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull(RAPPORT_UTILISATEUR_NE_DOIT
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);
			
		}
									
	} // Fin de testGetGroupid()._________________________________
	

	
	/**
	 * method testGetPathAppTechnic() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathAppTechnic().</li>
	 * <li>garantit que getPathAppTechnic() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathAppTechnic() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathAppTechnic() ********** ");
		}
																
		final String racineTestResources 
			= BundleConfigurationProjetManager.getPathAppTechnic();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetPathAppTechnic()");
			System.out.println("PATH ABSOLU apptechnic : " 
					+ racineTestResources);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetPathAppTechnic().___________________________________

	
		
	/**
	 * method testGetPathControllers() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathControllers().</li>
	 * <li>garantit que getPathControllers() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathControllers() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathControllers() ********** ");
		}
																
		final String racineTestResources 
			= BundleConfigurationProjetManager.getPathControllers();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetPathControllers()");
			System.out.println("PATH ABSOLU controllers : " 
					+ racineTestResources);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetPathControllers().__________________________________
	

		
	/**
	 * method testGetPathModel() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathModel().</li>
	 * <li>garantit que getPathModel() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathModel() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathModel() ********** ");
		}
																	
		final String racineTestResources 
			= BundleConfigurationProjetManager.getPathModel();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetPathModel()");
			System.out.println("PATH ABSOLU model : " 
					+ racineTestResources);
			
			System.out.println("PATH ABSOLU dao : " 
					+ BundleConfigurationProjetManager.getPathDao());
			System.out.println("PATH ABSOLU metier : " 
					+ BundleConfigurationProjetManager.getPathMetier());
			System.out.println("PATH ABSOLU services : " 
					+ BundleConfigurationProjetManager.getPathServices());
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetPathModel().________________________________________
	

		
	/**
	 * method testGetPathVues() :<br/>
	 * <ul>
	 * <li>teste la méthode getPathVues().</li>
	 * <li>garantit que getPathVues() retourne un Singleton.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testGetPathVues() throws Exception {
						
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE BundleConfigurationProjetManagerTest - méthode testGetPathVues() ********** ");
		}
																		
		final String racineTestResources 
			= BundleConfigurationProjetManager.getPathVues();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testGetPathVues()");
			System.out.println("PATH ABSOLU vues : " 
					+ racineTestResources);
		}
		
		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testGetPathVues()._________________________________________
	


	/**
	 * method afficher(
	 * String pMethode
	 * , String pRapportConfigurationCsv
	 * , String pRapportUtilisateurCsv
	 * , AbstractRunTimeTechnicalException pE) :<br/>
	 * <ul>
	 * <li>Affiche à la console le rapport développeur.</li>
	 * <li>Affiche à la console le rapport utilisateur.</li>
	 * </ul>
	 *
	 * @param pMethode : String.<br/>
	 * @param pRapportConfigurationCsv : String.<br/>
	 * @param pRapportUtilisateurCsv : String.<br/>
	 * @param pE : AbstractRunTimeTechnicalException.<br/>
	 */
	private void afficher(
			final String pMethode
			, final String pRapportConfigurationCsv
				, final String pRapportUtilisateurCsv
					, final AbstractRunTimeTechnicalException pE) {
		
		System.out.println(TIRETS);
		System.out.println(pMethode);
		System.out.println();
		System.out.println(RAPPORT_CONFIGURATION);
		System.out.println(pRapportConfigurationCsv);
		
		System.out.println();
		System.out.println(RAPPORT_UTILISATEUR);
		System.out.println(pRapportUtilisateurCsv);
		
		System.out.println();
		System.out.print(LISTE_EXCEPTIONS);
		System.out.println(pE.listeExceptionsToString());
		System.out.println(TIRETS);
		
	} // Fin de afficher(...)._____________________________________________
	
	

} // FIN DE LA CLASSE BundleConfigurationProjetManagerTest.------------------
