package levy.daniel.application.model.services.utilitaires.upload.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.util.Files;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import levy.daniel.application.apptechnic.exceptions.technical.impl.StorageFileNotFoundRunTimeException;

/**
 * CLASSE FileSystemUploadServiceTest :<br/>
 * Test JUnit de {@link FileSystemUploadService}.<br/>
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
 * @since 25 oct. 2019
 *
 */
public class FileSystemUploadServiceTest {

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
	 * "le fichier uploadé ne doit pas exister : ".
	 */
	public static final String FICHIER_UPLOADE_NE_DOIT_PAS_EXISTER = 
			"le fichier uploadé ne doit pas exister : ";

	/**
	 * "le fichier uploadé doit être null : ".
	 */
	public static final String FICHIER_UPLOADE_DOIT_ETRE_NULL 
		= "le fichier uploadé doit être null : ";
	
	/**
	 * "doit jeter une StorageFileNotFoundRunTimeException : ".
	 */
	public static final String DOIT_JETER_STORAGE_FILE_NOT_FOUND_EXC 
		= "doit jeter une StorageFileNotFoundRunTimeException : ";
	
	/**
	 * "foo.txt".
	 */
	public static final String FOO_TXT = "foo.txt";
	
	/**
	 * "foo".
	 */
	public static final String FOO = "foo";
	
    /**
     * FileSystemUploadService instancié dans la méthode init() 
     * avant chaque test.<br/>
     */
    private transient FileSystemUploadService service;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings(UNUSED)
	private static final Log LOG 
		= LogFactory.getLog(FileSystemUploadServiceTest.class);

	// *************************METHODES************************************/
	   
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public FileSystemUploadServiceTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

    
    
    /**
     * <p>teste la méthode nommerFichierCible(String pFileName).</p>
     * <ul>
     * <li>garantit que nommerFichierCible(inexistant) 
     * retourne un Path inexistant.</li>
     * </ul>
     */
	@SuppressWarnings(UNUSED)
    @Test
    public void testNommerFichierCibleNonExistant() {
		    				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testNommerFichierCibleNonExistant() ********** ");
		}

		/* garantit que nommerFichierCible(inexistant) 
		 * retourne un Path inexistant. */
        assertThat(this.service.nommerFichierCible(FOO_TXT)).doesNotExist();
        
    } // Fin de testNommerFichierCibleNonExistant()._________________________

    
    	
	/**
	 * teste la méthode 
	 * <code>upload(null, File pFileTarget)</code>.<br/>
	 * <ul>
	 * <li>garantit que <code>upload(null, File pFileTarget)</code> 
	 * jette une Exception lorsque le fichier source est null.</li>
	 * <li>garantit que le fichier uploadé est null.</li>
	 * <li>garantit que le fichier uploadé n'existe pas.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
    @Test
    public void testUploadFileSourceNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testUploadFileSourceNull() ********** ");
		}
   	
		// VALEURS A TESTER ******************************************************
		final MockMultipartFile foo = null;
		
		final File fileTarget = new File("televersements/null.txt");		
		// VALEURS A TESTER ******************************************************
		
		
		// METHODE A TESTER *************************************************
		File resultat = null;
		
		try {
			
			resultat = this.service.uploadOneFile(foo, fileTarget);
			
			/* garantit que le fichier uploadé n'existe pas. */
	        if (resultat != null) {
	        	assertFalse(FICHIER_UPLOADE_NE_DOIT_PAS_EXISTER
	        			, resultat.exists());
	        }
			
		} catch (Exception e) {
			
			assertTrue(DOIT_JETER_STORAGE_FILE_NOT_FOUND_EXC
					, e instanceof StorageFileNotFoundRunTimeException);
		}
        // *******************************************************************
        
		// ASSERTIONS
		/* garantit que le fichier uploadé est null. */
        assertNull(FICHIER_UPLOADE_DOIT_ETRE_NULL, resultat);
                
    } // Fin de testUploadFileSourceNull().________________________________


	
	/**
	 * teste la méthode 
	 * <code>upload(vide, File pFileTarget)</code>.<br/>
	 * <ul>
	 * <li>garantit que <code>upload(vide, File pFileTarget)</code> 
	 * jette une Exception lorsque le fichier source est vide.</li>
	 * <li>garantit que le fichier uploadé est null.</li>
	 * <li>garantit que le fichier uploadé n'existe pas.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
    @Test
    public void testUploadFileSourceVide() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testUploadFileSourceVide() ********** ");
		}
   	
		// VALEURS A TESTER ******************************************************
		final MockMultipartFile foo = new MockMultipartFile(
				"test_source_vide"
				, "test_source_vide.txt"
				, MediaType.TEXT_PLAIN_VALUE
				, "".getBytes(StandardCharsets.UTF_8));
		
		final File fileTarget = new File("televersements/vide.txt");		
		// VALEURS A TESTER ******************************************************
		
		
		// METHODE A TESTER *************************************************
		File resultat = null;
		
		try {
			
			resultat = this.service.uploadOneFile(foo, fileTarget);
			
			/* garantit que le fichier uploadé n'existe pas. */
	        if (resultat != null) {
	        	assertFalse(FICHIER_UPLOADE_NE_DOIT_PAS_EXISTER
	        			, resultat.exists());
	        }
			
		} catch (Exception e) {
			
			assertTrue(DOIT_JETER_STORAGE_FILE_NOT_FOUND_EXC
					, e instanceof StorageFileNotFoundRunTimeException);
		}
        // *******************************************************************
        
		// ASSERTIONS
		/* garantit que le fichier uploadé est null. */
        assertNull(FICHIER_UPLOADE_DOIT_ETRE_NULL, resultat);
                
    } // Fin de testUploadFileSourceVide().________________________________


	
	/**
	 * teste la méthode 
	 * <code>upload(MultipartFile pFileSource, null)</code>.<br/>
	 * <ul>
	 * <li>garantit que <code>upload(MultipartFile pFileSource, null)</code> 
	 * jette une Exception lorsque le fichier destination est null.</li>
	 * <li>garantit que le fichier uploadé est null.</li>
	 * <li>garantit que le fichier uploadé n'existe pas.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
    @Test
    public void testUploadFileTargetNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testUploadFileTargetNull() ********** ");
		}
   	
		// VALEURS A TESTER ******************************************************
		final MockMultipartFile foo = new MockMultipartFile(
				"test_target_null"
				, "test_target_null.txt"
				, MediaType.TEXT_PLAIN_VALUE
				, "Ceci est un test d'upload en UTF-8 grâve bêèéle".getBytes(StandardCharsets.UTF_8));
		
		final File fileTarget = null;		
		// VALEURS A TESTER ******************************************************
		
		
		// METHODE A TESTER *************************************************
		File resultat = null;
		
		try {
			
			resultat = this.service.uploadOneFile(foo, fileTarget);
			
			/* garantit que le fichier uploadé n'existe pas. */
	        if (resultat != null) {
	        	assertFalse(FICHIER_UPLOADE_NE_DOIT_PAS_EXISTER
	        			, resultat.exists());
	        }
			
		} catch (Exception e) {
			
			assertTrue(DOIT_JETER_STORAGE_FILE_NOT_FOUND_EXC
					, e instanceof StorageFileNotFoundRunTimeException);
		}
        // *******************************************************************
        
		// ASSERTIONS
		/* garantit que le fichier uploadé est null. */
        assertNull(FICHIER_UPLOADE_DOIT_ETRE_NULL, resultat);
                
    } // Fin de testUploadFileTargetNull().________________________________


	
	/**
	 * teste la méthode 
	 * <code>upload(MultipartFile pFileSource, repertoire)</code>.<br/>
	 * <ul>
	 * <li>garantit que <code>upload(MultipartFile pFileSource, repertoire)</code> 
	 * jette une Exception lorsque le fichier destination est repertoire.</li>
	 * <li>garantit que le fichier uploadé est null.</li>
	 * <li>garantit que le fichier uploadé n'existe pas.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
    @Test
    public void testUploadFileTargetRepertoire() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testUploadFileTargetRepertoire() ********** ");
		}
   	
		// VALEURS A TESTER ******************************************************
		final MockMultipartFile foo = new MockMultipartFile(
				"test_target_repertoire"
				, "test_target_repertoire.txt"
				, MediaType.TEXT_PLAIN_VALUE
				, "Ceci est un test d'upload en UTF-8 grâve bêèéle".getBytes(StandardCharsets.UTF_8));
		
		final File fileTarget = new File("logs");		
		// VALEURS A TESTER ******************************************************
		
		
		// METHODE A TESTER *************************************************
		File resultat = null;
		
		try {
			
			resultat = this.service.uploadOneFile(foo, fileTarget);
			
			/* garantit que le fichier uploadé n'existe pas. */
	        if (resultat != null) {
	        	assertFalse(FICHIER_UPLOADE_NE_DOIT_PAS_EXISTER
	        			, resultat.exists());
	        }
			
		} catch (Exception e) {
			
			assertTrue(DOIT_JETER_STORAGE_FILE_NOT_FOUND_EXC
					, e instanceof StorageFileNotFoundRunTimeException);
		}
        // *******************************************************************
        
		// ASSERTIONS
		/* garantit que le fichier uploadé est null. */
        assertNull(FICHIER_UPLOADE_DOIT_ETRE_NULL, resultat);
                
    } // Fin de testUploadFileTargetRepertoire().__________________________


	
	/**
	 * teste la méthode 
	 * <code>upload(MultipartFile pFileSource, File pFileTarget)</code>.<br/>
	 * <ul>
	 * <li>garantit que le fichier est bien uploadé.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
    @Test
    public void testUpload() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testUpload() ********** ");
		}
   	
		// VALEURS A TESTER ******************************************************
		final String originalFileName = "test_upload.txt";
		
		final MockMultipartFile foo = new MockMultipartFile(
				"test_upload"
				, originalFileName
				, MediaType.TEXT_PLAIN_VALUE
				, "Ceci est un test d'upload en UTF-8 grâve bêèéle".getBytes(StandardCharsets.UTF_8));
		
		final File fileTarget = new File("televersements/testUpload.txt");		
		// VALEURS A TESTER ******************************************************
		
		
		// METHODE A TESTER *************************************************
        this.service.uploadOneFile(foo, fileTarget);
        // *******************************************************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Le fichier '" + originalFileName + "' a bien été uploadé en " + fileTarget.getAbsolutePath());
		}
        
		/* garantit que le fichier est bien uploadé. */
        assertThat(fileTarget.exists());
        
        /* destruction du fichier uploadé. */
        if (fileTarget.exists()) {
        	Files.delete(fileTarget);
        }
        
        /* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(fileTarget.getAbsolutePath() + " a été détruit");
		}
		
    } // Fin de testUpload().______________________________________________
	
	
	
	/**
	 * teste la méthode 
	 * <code>upload(MultipartFile pFileSource, File pFileTarget)</code>.<br/>
	 * <ul>
	 * <li>garantit que le fichier est bien uploadé.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings(UNUSED)
    @Test
    public void testUploadReel() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE FileSystemUploadServiceTest - méthode testUploadReel() ********** ");
		}
   	
		// VALEURS A TESTER ******************************************************
		final File fichierSource = new File("./src/test/resources/jeux_essai/2018/HITDIRE2018.txt");
		final String fichierSourceName = "HITDIRE2018.txt";
		final String fichierSourceoriginalFileName = "HITDIRE2018.txt";
		
		FileInputStream inputStream = null;
		InputStreamReader inputSreamReader = null;
		MultipartFile foo = null;
		
		try {
			
			inputStream = new FileInputStream(fichierSource);
			inputSreamReader = new InputStreamReader(inputStream, Charset.forName("Windows-1252"));
			
			foo = new MockMultipartFile(
					fichierSourceName
						, fichierSourceoriginalFileName
							, MediaType.TEXT_PLAIN_VALUE
								, IOUtils.toByteArray(inputSreamReader, Charset.forName("Windows-1252")));
			
		} catch (Exception e) {
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("impossible de lire le fichier : " + fichierSource.getAbsolutePath(), e);
			}
			
		} finally {
			
			if (inputSreamReader != null) {
				inputSreamReader.close();
			}
			
			if (inputStream != null) {
				inputStream.close();
			}
			
		}
			
		final File fileTarget = new File("televersements/2018/DIRE/HITDIRE2018_ANSI_TEST.txt");		
		// FIN DE VALEURS A TESTER ********************************************
		
		
		// METHODE A TESTER *************************************************
        final File resultat = this.service.uploadOneFile(foo, fileTarget);
        // *******************************************************************
        
        /* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Le fichier '" + fichierSourceoriginalFileName + "' a bien été uploadé en " + resultat.getAbsolutePath());
		}
        
		/* garantit que le fichier est bien uploadé. */
		assertEquals("Les 2 fichiers (source et uploadé) doivent avoir la même longueur : "
				, fichierSource.length(), resultat.length());
        
        /* destruction du fichier uploadé. */
        if (fileTarget.exists()) {
        	Files.delete(fileTarget);
        }
        
        /* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(fileTarget.getAbsolutePath() + " a été détruit");
		}
		
    } // Fin de testUploadReel().__________________________________________

    
       
	/**
	  * Exécuté avant chaque test de la classe.<br/>
	  * 
	  * @throws Exception 
	  */
    @Before
    public void init() throws Exception {
    	
        this.service = new FileSystemUploadService();
        
    } // Fin de init().____________________________________________________
    


} // FIN DE LA CLASSE FileSystemUploadServiceTest.---------------------------
