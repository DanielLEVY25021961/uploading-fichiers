package levy.daniel.application.model.persistence.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.IConstantesApplicatives;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairespaths.ManagerPaths;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.daoexceptions.technical.impl.DaoDoublonException;


/**
 * CLASSE JPAUtils :<br/>
 * CLASSE UTILITAIRE CHARGEE DE FOURNIR 
 * UN SINGLETON D'EntityManagerFactory.<br/>
 * <ul>
 * <li>A UTILISER AVEC JPA <b>SANS SPRING</b>.</li>
 * <li>le SINGLETON EntityManagerFactory lit 
 * le <b>META-INF/persistence.xml</b> 
 * et charge toutes ses Properties (connexion à la base, dialecte, ...).</li>
 * <li>le SINGLETON EntityManagerFactory créera toutes les instances 
 * nécéssaires d'EntityManager pour toutes les actions (CRUD) 
 * dans les DAOs.</li>
 * </ul>
 * <br/>
 *
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * 
 * - Mots-clé :<br/>
 * <br/>
 * <img src="../../../../../../../../../javadoc/images/Relations Java entre File-Path-String.png" 
 * alt="transitions File-Path-String" border="1" align="center" />
 * <br/><br/>
 * <ul>
 * <li>String vers Path : <b>Paths.get(string);</b>, String to Path, </li>
 * <li>Path vers String : <b>path.toString();</b>, Path to String, </li>
 * <li>Path vers File : <b>path.toFile();</b>, Path to File, </li>
 * <li>File vers Path : <b>file.toPath();</b>, File to Path, </li>
 * <li>String vers File : <b>new File(string);</b>, String to File, </li>
 * <li>File vers String : <b>file.getAbsolutePath();</b>, File to String, </li>
 * </ul>
 * <ul>
 * <li>Ajouter un path2 à path1 : <b>pathResultat = path1.resolve(path2);</b>.</li>
 * <li>Soustraire un path2 à path1 : pathRelatif = path1.relativize(path2);<b></b>.</li>  
 * copie de fichiers, Files.copy(), <br/>
 * déplacement de fichiers, écrasement, <br/>
 * lire un fichier : Files.readAllLines(path), <br/>
 * </ul>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 mai 2018
 *
 */
public final class JPAUtils {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Persistence-unit déclarée dans META-INF/Persistence.xml.<br/>
	 * "persistence_unit_base-adresses_javafx".<br/>
	 */
	public static final String PERSISTENCE_UNIT 
		= "persistence_unit_base-adresses_javafx";

	/**
	 * "Classe JPAUtils".<br/>
	 */
	public static final String CLASSE_JPAUTILS 
		= "Classe JPAUtils";
	
	/**
	 * "Méthode getEntityManagerFactory()".<br/>
	 */
	public static final String METHODE_GETENTITYMANAGERFACTORY 
		= "Méthode getEntityManagerFactory()";
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
		
	/**
	 * PROPERTY_PERSISTENCE_UNIT.<br/>
	 */
	public static final String PROPERTY_PERSISTENCE_UNIT 
		= "hibernate.ejb.persistenceUnitName";
	
	/**
	 * "hibernate.transaction.coordinator_class".<br/>
	 */
	public static final String PROPERTY_TRANSACTION_TYPE 
		= "hibernate.transaction.coordinator_class";

	/**
	 * "hibernate.connection.url".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_CONNECTION_URL 
		= "hibernate.connection.url";
	
	/**
	 * "hibernate.connection.username".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_CONNECTION_USERNAME 
		= "hibernate.connection.username";
	
	/**
	 * "hibernate.connection.password".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_CONNECTION_PASSWORD 
		= "hibernate.connection.password";
	
	/**
	 * "javax.persistence.jdbc.driver".<br/>
	 */
	public static final String PROPERTY_DRIVER 
		= "javax.persistence.jdbc.driver";
	
	/**
	 * "hibernate.dialect".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_DIALECT 
		= "hibernate.dialect";
	
	/**
	 * "hibernate.show_sql".<br/>
	 */
	public static final String PROPERTY_SHOW_SQL 
		= "hibernate.show_sql";
	
	/**
	 * "hibernate.format_sql".<br/>
	 */
	public static final String PROPERTY_FORMAT_SQL 
		= "hibernate.format_sql";
	
	/**
	 * "hibernate.use_sql_comments".<br/>
	 */
	public static final String PROPERTY_USE_SQL_COMMENTS 
		= "hibernate.use_sql_comments";
	
	/**
	 * "hibernate.generate_statistics".<br/>
	 */
	public static final String PROPERTY_GENERATE_STATISTICS 
		= "hibernate.generate_statistics";
	
	/**
	 * "cache.provider_class".<br/>
	 */
	public static final String PROPERTY_CACHE_PROVIDER 
		= "cache.provider_class";
	
	/**
	 * "hibernate.hbm2ddl.auto".<br/>
	 */
	public static final String PROPERTY_HBM2DDL_AUTO 
		= "hibernate.hbm2ddl.auto";
	
	/**
	 * "java.specification.version".<br/>
	 */
	public static final String PROPERTY_VERSION_JAVA 
		= "java.specification.version";
	
	/**
	 * "java.class.path".<br/>
	 */
	public static final String PROPERTY_CLASS_PATH 
		= "java.class.path";
	
	/**
	 * "user.timezone".<br/>
	 */
	public static final String PROPERTY_USER_TIMEZONE 
		= "user.timezone";
	
	/**
	 * "os.name".<br/>
	 */
	public static final String PROPERTY_OS_NAME 
		= "os.name";
	
	/**
	 * "os.version".<br/>
	 */
	public static final String PROPERTY_OS_VERSION 
		= "os.version";
	
	/**
	 * "user.language".<br/>
	 */
	public static final String PROPERTY_USER_LANGAGE 
		= "user.language";
	
	/**
	 * "user.country".<br/>
	 */
	public static final String PROPERTY_USER_COUNTRY 
		= "user.country";
	
	/**
	 * "file.encoding".<br/>
	 */
	public static final String PROPERTY_FILE_ENCODING 
		= "file.encoding";
	
	/**
	 * "user.dir".<br/>
	 */
	public static final String PROPERTY_REP_PROJET 
		= "user.dir";
	
	/**
	 * EntityManagerFactory JPA.<br/>
	 */
	private static EntityManagerFactory entityManagerFactory;

	/**
	 * Map&lt;String,Object&gt; des properties 
	 * lues par l'EntityManagerFactory.<br/>
	 */
	private static Map<String, Object> properties;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(JPAUtils.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	private JPAUtils() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
		
	/**
	 * <b>retourne un SINGLETON d'EntityManagerFactory</b>.<br/>
	 * <ul>
	 * <li><b>lit</b> 
	 * <code><b>src/main/resources/META-INF/persistence.xml</b></code></li>
	 * <li>
	 * le <code>META-INF/persistence.xml</code> contient la 
	 * <b>CONFIGURATION DU CONTEXTE</b> :
	 * <ul>
	 * <li>le <b>NOM de l'unité de persistence</b> 
	 * <code><b>persistence-unit name</b></code>.</li>
	 * <li>le <b>TYPE DE TRANSACTION</b> (RESOURCE_LOCAL en desktop
	 * , JTA avec TOMCAT sans Spring lorsque le serveur TOMCAT 
	 * gère les transactions, rien avec SPRING, ...).</li>
	 * <li>le <b>PROVIDER</b> d'ORM (HIBERNATE, EclipseLink, OpenJPA, ...).</li>
	 * <li>l'<b>URL</b> de connexion à la BASE 
	 * <code><b>javax.persistence.jdbc.url</b></code></li>
	 * <li>le <b>LOGIN</b> <code><b>javax.persistence.jdbc.user</b></code></li>
	 * <li>le <b>MOT DE PASSE</b> 
	 * <code><b>javax.persistence.jdbc.password</b></code></li>
	 * <li>le <b>DRIVER</b> de la BASE 
	 * <code><b>javax.persistence.jdbc.driver</b></code></li>
	 * <li>le <b>DIALECTE</b> dépendant du provider choisi 
	 * comme pour HIBERNATE <code><b>hibernate.dialect</b></code></li>
	 * <li>les réglages propres au provider (hibernate.show_sql
	 * , hibernate.format_sql, hibernate.use_sql_comments
	 * , hibernate.generate_statistics, ...)</li>
	 * <li>le cache de second niveau 
	 * <code><b>cache.provider_class</b></code></li>
	 * <li>la stratégie de conservation des tables 
	 * <code><b>hibernate.hbm2ddl.auto</b></code></li>
	 * <li>le <b>pool de connexion</b></li>
	 * </ul>
	 * </li>
	 * <li><b>nécessite que le serveur de base de données indiqué dans 
	 * persistence.xml soit démarré</b>.</li>
	 * <li>charge la configuration du contexte de persistence 
	 * dans entityManagerFactory.</li>
	 * <li>retourne un <b>SINGLETON</b> entityManagerFactory.</li>
	 * </ul>
	 *
	 * @return : entityManagerFactory : 
	 * SINGLETON d'EntityManagerFactory.<br/>
	 * 
	 * @throws PersistenceException : 
	 * si la persistence-unit est introuvable dans 
	 * META-INF/persistence.xml.<br/>
	 */
	public static EntityManagerFactory getEntityManagerFactory() 
			throws PersistenceException {
		
		synchronized(JPAUtils.class) {
			
			if (entityManagerFactory == null 
					|| !entityManagerFactory.isOpen()) {
				
				try {

					entityManagerFactory 
					= Persistence
						.createEntityManagerFactory(PERSISTENCE_UNIT);
					
				} catch (Exception e) {
					
					final String message 
					= CLASSE_JPAUTILS 
					+ IConstantesApplicatives.SEPARATEUR_MOINS_AERE 
					+ METHODE_GETENTITYMANAGERFACTORY 
					+ IConstantesApplicatives.SEPARATEUR_MOINS_AERE 
					+ "IMPOSSIBLE D'ACCEDER AU SERVEUR DE BD";
					
					if (LOG.isFatalEnabled()) {
						LOG.fatal(message, e);
					}
				}
				
			}
			
			return entityManagerFactory;
			
		} // Fin du bloc synchronized._____________________
				
	} // Fin de getEntityManagerFactory()._________________________________
	

	
	/**
	 * <b>fournit une nouvelle instance d'EntityManager 
	 * à chaque appel</b>.<br/>
	 *
	 * @return : EntityManager.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	public static EntityManager fournirEntityManager() 
			throws AbstractDaoException {
		
		synchronized(JPAUtils.class) {
			
			if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
				
				try {
					entityManagerFactory = JPAUtils.getEntityManagerFactory();
				} catch (Exception e) {
					throw new DaoDoublonException("IMPOSSIBLE", e);
				}
				
			}
								
			if (entityManagerFactory != null) {
				return entityManagerFactory.createEntityManager();
			}
			
			return null;

		} // Fin du bloc synchronized._____________________
		
	} // Fin de fournirEntityManager().____________________________________


	
	/**
	 * <b>Retourne les properties lues dans le fichier persistence.xml 
	 * par l' entityManagerFactory et des propriétés système</b>.<br/>
	 * <br/>
	 *
	 * @return : Map&lt;String, Object&gt; : Map des properties.<br/>
	 */
	public static Map<String, Object> getProperties() {
		
		synchronized(JPAUtils.class) {
		
			if (entityManagerFactory == null) {
				getEntityManagerFactory();
			}
			
			if (entityManagerFactory != null) {
				
				if (properties == null) {
					
					properties 
					= entityManagerFactory.getProperties();
				}
				
				return properties;
			}
			
			return null;
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de getProperties().___________________________________________
	


	/**
	 * <b>Retourne la Property ayant pour clé pKey</b>.<br/>
	 * <ul>
	 * <li>retourne null si pKey == null.</li>
	 * </ul>
	 *
	 * @param pKey : String.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public static String getProperty(
			final String pKey) {
		
		synchronized(JPAUtils.class) {
			
			/* retourne null si pKey == null. */
			if (pKey == null) {
				return null;
			}

			if (entityManagerFactory == null) {
				getEntityManagerFactory();
			}
			
			if (properties == null) {			
				properties 
					= entityManagerFactory.getProperties();
			}
			
			final Object resultat = properties.get(pKey);
			
			if (resultat != null) {
				return resultat.toString();
			}
			
			return null;
			
		} // Fin du bloc synchronized._____________________
				
	} // Fin de getProperty(...).__________________________________________
	
	
	
	/**
	 * <b>détermine si une EntityJPA pEntity 
	 * a été chargée dans le contexte</b>.<br/>
	 * <ul>
	 * <li>par exemple : <br/>
	 * <code>boolean resultat = JPAUtils.isLoaded(
	 * ContactSimpleEntityJPA.class);</code> 
	 * <br/>retourne true si 
	 * l'Entity a été chargée.</li>
	 * </ul>
	 *
	 * @param pEntity : Object : Entity JPA (.class).<br/>
	 * 
	 * @return boolean : true si l'Entity a été chargée.<br/>
	 * 
	 * @throws PersistenceException
	 */
	public static boolean isLoaded(
			final Object pEntity) 
					throws PersistenceException {
		
		synchronized(JPAUtils.class) {
			
			final PersistenceUtil persistenceUtil 
				= Persistence.getPersistenceUtil();
			
			final boolean resultat = persistenceUtil.isLoaded(pEntity);
			
			return resultat;
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de isLoaded(...)._____________________________________________
	

	
	/**
	 * <b>Ferme l'EntityManagerFactory</b>.<br/>
	 */
	public static void close() {
		
		synchronized(JPAUtils.class) {
			
			if (entityManagerFactory != null) {
				if (entityManagerFactory.isOpen()) {
					entityManagerFactory.close();
				}
			}
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de close().___________________________________________________


	
	/**
	 * met l'EntityManagerFactory à  null.<br/>
	 */
	public static void annulerEntityManagerFactory() {
		
		synchronized(JPAUtils.class) {
			
			if (entityManagerFactory != null) {
				entityManagerFactory = null;
			}
			
		} // Fin du bloc synchronized._____________________

	} // Fin de annulerEntityManagerFactory()._____________________________
	
	
	
	/**
	 * <b>Substitue</b> le contenu du 
	 * src/main/resources/META-INF/persistence.xml 
	 * avec le contenu de persistence-test.xml de <b>TEST</b>.<br/>
	 * <ul>
	 * <li>Crée une copie de src/main/resources/META-INF/
	 * <b>persistence.xml</b> nommée "persistence.xml.original" 
	 * dans le même répertoire src/main/resources/META-INF/.</li>
	 * <li>Remplace le contenu de src/main/resources/META-INF/
	 * <b>persistence.xml</b> par le contenu de 
	 * src/test/resources/META-INF/<b>persistence-test.xml</b></li>
	 * <li>Le contenu de persistence-test.xml et donc lu 
	 * par l'EntityManagerFactory.</li>
	 * </ul>
	 *
	 * @throws IOException
	 */
	public static void activerPersistenceTestXml() throws IOException {

		synchronized (JPAUtils.class) {

			final Path pathAbsoluPersistenceXml 
				= fournirPathAbsoluPersistenceXml();

			final Path pathAbsoluPersistenceTestXml 
				= fournirPathAbsoluPersistenceTestXml();

			/* Copie persistence.xml sous 
			 * persistence.xml.original. */
			copierFichierDansMemeRepertoire(
					pathAbsoluPersistenceXml
						, "persistence.xml.original");

			/* Remplace persistence.xml par le contenu 
			 * de persistence-test.xml. */
			remplacerFichier(
					pathAbsoluPersistenceTestXml
						, pathAbsoluPersistenceXml);
			
		} // Fin du bloc synchronized._____________________

	} // Fin de activerPersistenceTestXml()._______________________________
	
	
	
	/**
	 * <b>Remet en place le contenu du persistence.xml de PROD</b>.<br/>
	 * <ul>
	 * <li>persistence.xml avait préalablement été copié 
	 * dans "persistence.xml.original".</li>
	 * <li>le contenu de persistence.xml avait été remplacé par le 
	 * contenu de <b>persistence-test.xml</b> durant les tests.</li>
	 * <li>Remplace le contenu de persistence.xml 
	 * (en réalité persistence-test.xml) par le contenu original 
	 * sauvegardé dans "persistence.xml.original".</li>
	 * <li>détruit ensuite "persistence.xml.original".</li>
	 * <li>l'état INITIAL (avant tests) est ainsi restitué.</li>
	 * </ul>
	 * - ne fait rien si pathFichierOriginal == null.<br/>
	 * - ne fait rien si fileOriginal n'existe pas.<br/>
	 * <br/>
	 *
	 * @throws IOException
	 */
	public static void activerPersistenceXml() throws IOException {
		
		synchronized (JPAUtils.class) {
			
			final Path pathFichierOriginal 
			= fournirPathAbsoluPersistenceXml()
				.resolveSibling("persistence.xml.original");
		
			/* ne fait rien si pathFichierOriginal == null. */
			if (pathFichierOriginal == null) {
				return;
			}
			
			final File fileOriginal = pathFichierOriginal.toFile();
			
			/* ne fait rien si fileOriginal n'existe pas. */
			if (!fileOriginal.exists()) {
				return;
			}
			
			/* Remplace le contenu de persistence.xml 
			 * (en réalité persistence-test.xml) par le contenu original 
			 * sauvegardé dans "persistence.xml.original". */
			remplacerFichier(
					pathFichierOriginal
						, fournirPathAbsoluPersistenceXml());
			
			/* détruit ensuite "persistence.xml.original".*/
			Files.deleteIfExists(pathFichierOriginal);
		
		} // Fin du bloc synchronized._____________________
		
	} // Fin de activerPersistenceXml().___________________________________
	

	
	/**
	 * Copie le fichier situé à pPath dans le <b>même répertoire</b> 
	 * en nommant la copie pNouveauNom.<br/>
	 * <ul>
	 * <li>recopie le fichier situé à pPath 
	 * dans le même répertoire que pPath.</li>
	 * <li>nomme la copie pNouveauNom.</li>
	 * </ul>
	 * - ne fait rien si pPath == null.<br/>
	 * - ne fait rien si le fichier situé à pPath n'existe pas.<br/>
	 * - ne fait rien si le file situé à pPath est un répertoire.<br/>
	 * - ne fait rien si pNouveauNom == null.<br/>
	 * <br/>
	 *
	 * @param pPath : Path : path du fichier à copier.<br/>
	 * @param pNouveauNom : String : Nom à donner à la copie.<br/>
	 * 
	 * @throws IOException 
	 */
	private static void copierFichierDansMemeRepertoire(
			final Path pPath
				, final String pNouveauNom) throws IOException {
		
		synchronized (JPAUtils.class) {
			
			/* ne fait rien si pPath == null. */
			if (pPath == null) {
				return;
			}
			
			final File fileACopier = pPath.toFile();
			
			/* ne fait rien si le fichier situé à pPath n'existe pas. */
			if (!fileACopier.exists()) {
				return;
			}
			
			/* ne fait rien si le file situé à pPath est un répertoire. */
			if (fileACopier.isDirectory()) {
				return;
			}
			
			/* ne fait rien si pNouveauNom == null. */
			if (pNouveauNom == null) {
				return;
			}
			
			/* COPY et RENOMMAGE. */
			Files.copy(pPath
						, pPath.resolveSibling(pNouveauNom)
							, StandardCopyOption.REPLACE_EXISTING);
			
		} // Fin du bloc synchronized._____________________
				
	} // Fin de copierFichierDansMemeRepertoire(...).______________________
	
	
	
	/**
	 * Ecrase le fichier situé à pPathFichierARemplacer 
	 * et le remplace par le fichier situé à pPathFichierRemplacement.<br/>
	 * <ul>
	 * <li>Remplace le contenu de pPathFichierARemplacer 
	 * par le contenu de 
	 * pPathFichierRemplacement.</li>
	 * </ul>
	 * - ne fait rien si pPathFichierRemplacement == null.<br/>
	 * - ne fait rien si fileRemplacement n'existe pas.<br/>
	 * - ne fait rien si fileRemplacement est un répertoire.<br/>
	 * - ne fait rien si pPathFichierARemplacer == null.<br/>
	 * - ne fait rien si fileARemplacert n'existe pas.<br/>
	 * - ne fait rien si fileARemplacert est un répertoire.<br/>
	 * <br/>
	 *
	 * @param pPathFichierRemplacement : java.nio.Path : 
	 * Path du fichier qui doit remplacer pPathFichierARemplacer.<br/>
	 * @param pPathFichierARemplacer : java.nio.Path : 
	 * Path du fichier à remplacer.<br/>
	 * 
	 * @throws IOException
	 */
	private static Path remplacerFichier(
			final Path pPathFichierRemplacement
				, final Path pPathFichierARemplacer) throws IOException {

		synchronized (JPAUtils.class) {
						
			/* ne fait rien si pPathFichierRemplacement == null. */
			if (pPathFichierRemplacement == null) {
				return null;
			}
			
			final File fileRemplacement = pPathFichierRemplacement.toFile();
			
			/* ne fait rien si fileRemplacement n'existe pas. */
			if (!fileRemplacement.exists()) {
				return null;
			}
			
			/* ne fait rien si fileRemplacement est un répertoire. */
			if (fileRemplacement.isDirectory()) {
				return null;
			}
			
			/* ne fait rien si pPathFichierARemplacer == null. */
			if (pPathFichierARemplacer == null) {
				return null;
			}
			
			final File fileARemplacert = pPathFichierARemplacer.toFile();
			
			/* ne fait rien si fileARemplacert n'existe pas. */
			if (!fileARemplacert.exists()) {
				return null;
			}
			
			/* ne fait rien si fileARemplacert est un répertoire. */
			if (fileARemplacert.isDirectory()) {
				return null;
			}
			
			/* ECRASEMENT - REMPLACEMENT du fichier destination. */
			final Path resultat = Files.copy(
					pPathFichierRemplacement
						, pPathFichierARemplacer
							, StandardCopyOption.REPLACE_EXISTING);

			return resultat;
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de remplacerFichier(...)._____________________________________
	
	
	
	/**
	 * Fournit le path ABSOLU des main/resources.<br/>
	 * <ul>
	 * <li>Par exemple :<br/>
	 * <code>D:\Donnees\eclipse\eclipseworkspace_oxygen
	 * \adresses_javafx\src\main\resources</code>.</li>
	 * </ul>
	 *
	 * @return Path.<br/>
	 * 
	 * @throws IOException
	 */
	private static Path fournirPathAbsoluMainResources() 
			throws IOException {

		synchronized (JPAUtils.class) {
			
			final Path pathProjet 
				= ManagerPaths.getPathPresentProjet();
			
			final Path pathMainJavaResources 
				= pathProjet.resolve("src/main/resources");
			
			return pathMainJavaResources;
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de fournirPathAbsoluMainResources().__________________________

	
	
	/**
	 * Fournit le path ABSOLU de main/resources
	 * /META-INF/persistence.xml.<br/>
	 * <ul>
	 * <li>Par exemple :<br/>
	 * <code>D:\Donnees\eclipse\eclipseworkspace_oxygen\
	 * adresses_javafx\src\main\resources\META-INF\
	 * persistence.xml</code>.</li>
	 * </ul>
	 *
	 * @return Path.<br/>
	 * 
	 * @throws IOException
	 */
	private static Path fournirPathAbsoluPersistenceXml() 
				throws IOException {

		synchronized (JPAUtils.class) {
			
			final String pathStringRelatifPersistenceXml 
			= "META-INF/persistence.xml";
		
			final Path pathSRelatifPersistenceXml 
				= Paths.get(pathStringRelatifPersistenceXml);
			
			final Path pathAbsoluPersistenceXml 
				= fournirPathAbsoluMainResources()
					.resolve(pathSRelatifPersistenceXml);
			
			return pathAbsoluPersistenceXml;

		} // Fin du bloc synchronized._____________________
		
	} // Fin de fournirPathAbsoluPersistenceXml()._________________________


		
	/**
	 * Fournit le path ABSOLU des test/resources.<br/>
	 * <ul>
	 * <li>Par exemple :<br/>
	 * <code>D:\Donnees\eclipse\eclipseworkspace_oxygen
	 * \adresses_javafx\src\test\resources</code>.</li>
	 * </ul>
	 *
	 * @return Path.<br/>
	 * 
	 * @throws IOException
	 */
	private static Path fournirPathAbsoluTestResources() 
				throws IOException {

		synchronized (JPAUtils.class) {
			
			final Path pathProjet 
				= ManagerPaths.getPathPresentProjet();
			
			final Path pathTestJavaResources 
				= pathProjet.resolve("src/test/resources");
			
			return pathTestJavaResources;

		} // Fin du bloc synchronized._____________________
		
	} // Fin de fournirPathAbsoluTestResources().__________________________
	
	
	
	/**
	 * Fournit le path ABSOLU de test/resources
	 * /META-INF/persistence-test.xml.<br/>
	 * <ul>
	 * <li>Par exemple :<br/>
	 * <code>D:\Donnees\eclipse\eclipseworkspace_oxygen\
	 * adresses_javafx\src\test\resources\META-INF\
	 * persistence-test.xml</code>.</li>
	 * </ul>
	 *
	 * @return Path.<br/>
	 * 
	 * @throws IOException
	 */
	private static Path fournirPathAbsoluPersistenceTestXml() 
				throws IOException {
		
		synchronized (JPAUtils.class) {
			
			final String pathStringRelatifPersistenceTestXml 
				= "META-INF/persistence-test.xml";
		
			final Path pathSRelatifPersistenceTestXml 
				= Paths.get(pathStringRelatifPersistenceTestXml);
			
			final Path pathAbsoluPersistenceTestXml 
				= fournirPathAbsoluTestResources()
					.resolve(pathSRelatifPersistenceTestXml);
			
			return pathAbsoluPersistenceTestXml;
		
		} // Fin du bloc synchronized._____________________
		
	} // Fin de fournirPathAbsoluPersistenceTestXml()._____________________
	

	
	/**
	 * <b>retourne une String pour l'affichage des principales Properties 
	 * lues par l'EntityManagerFactory</b>.<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	public static String afficherPrincipalesProperties() {
		
		synchronized(JPAUtils.class) {
			
			if (entityManagerFactory == null) {
				getEntityManagerFactory();
			}
			
			if (properties == null) {			
				properties 
					= entityManagerFactory.getProperties();
			}
			
			final StringBuffer stb = new StringBuffer();
			
			final String persistenceUnit 
				= getProperty(PROPERTY_PERSISTENCE_UNIT);
			final String transactionType 
				= getProperty(PROPERTY_TRANSACTION_TYPE);
			final String url 
				= getProperty(PROPERTY_HIBERNATE_CONNECTION_URL);
			final String login
				= getProperty(PROPERTY_HIBERNATE_CONNECTION_USERNAME);
			final String mdp
				= getProperty(PROPERTY_HIBERNATE_CONNECTION_PASSWORD);
			final String driver
				= getProperty(PROPERTY_DRIVER);
			final String dialecte
				= getProperty(PROPERTY_HIBERNATE_DIALECT);
			final String showSql
				= getProperty(PROPERTY_SHOW_SQL);
			final String formatSql
				= getProperty(PROPERTY_FORMAT_SQL);
			final String commentsSql
				= getProperty(PROPERTY_USE_SQL_COMMENTS);
			final String statistics
				= getProperty(PROPERTY_GENERATE_STATISTICS);
			final String cache
				= getProperty(PROPERTY_CACHE_PROVIDER);
			final String generationSchema
				= getProperty(PROPERTY_HBM2DDL_AUTO);
			final String versionJava
				= getProperty(PROPERTY_VERSION_JAVA);
			final String classPath
				= getProperty(PROPERTY_CLASS_PATH);
			final String timeZone
				= getProperty(PROPERTY_USER_TIMEZONE);
			final String osName
				= getProperty(PROPERTY_OS_NAME);
			final String osVersion
				= getProperty(PROPERTY_OS_VERSION);
			final String userLangage
				= getProperty(PROPERTY_USER_LANGAGE);
			final String userCountry
				= getProperty(PROPERTY_USER_COUNTRY);
			final String encoding
				= getProperty(PROPERTY_FILE_ENCODING);
			final String projet
				= getProperty(PROPERTY_REP_PROJET);
			
			stb.append("Persistence-Unit : ");
			stb.append(persistenceUnit);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Transaction Type : ");
			stb.append(transactionType);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("URL De connexion à la base : ");
			stb.append(url);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Login : ");
			stb.append(login);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Mdp : ");
			stb.append(mdp);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Driver : ");
			stb.append(driver);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Dialecte : ");
			stb.append(dialecte);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Show SQL : ");
			stb.append(showSql);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Format SQL : ");
			stb.append(formatSql);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Commentaires SQL : ");
			stb.append(commentsSql);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Statistiques Hibernate : ");
			stb.append(statistics);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Cache de premier niveau : ");
			stb.append(cache);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Génération du Schéma de BD : ");
			stb.append(generationSchema);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Version de Java : ");
			stb.append(versionJava);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("ClassPath : ");
			stb.append(classPath);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("TimeZone : ");
			stb.append(timeZone);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("OS : ");
			stb.append(osName);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Version d'OS : ");
			stb.append(osVersion);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Langue : ");
			stb.append(userLangage);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Pays : ");
			stb.append(userCountry);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Encodage du persistence.xml : ");
			stb.append(encoding);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Répertoire du projet Java : ");
			stb.append(projet);
			stb.append(SAUT_LIGNE_PLATEFORME);
			
			return stb.toString();
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de afficherPrincipalesProperties().___________________________
	
	
	
	/**
	 * <b>retourne une String pour l'affichage de toutes les 
	 * Properties lues par l'EntityManagerFactory</b>.
	 *
	 * @return : String.<br/>
	 */
	public static String afficherProperties() {
		return afficherMapStringObject(getProperties());
	} // Fin de afficherProperties().______________________________________
	
	
	
	/**
	 * <b>Fournit une String pour l'affichage 
	 * d'une Map&lt;String, Object&gt;</b>.<br/>
	 * <ul>
	 * <li>retourne null si pMap == null.</li>
	 * </ul>
	 *
	 * @param pMap : Map&lt;String, Object&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public static String afficherMapStringObject(
			final Map<String, Object> pMap) {
		
		/* retourne null si pMap == null. */
		if (pMap == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		final Set<Entry<String, Object>> entrySet = pMap.entrySet();
		
		final Iterator<Entry<String, Object>> ite = entrySet.iterator();
		
		while (ite.hasNext()) {
			
			final Entry<String, Object> entry = ite.next();
			final String key = entry.getKey();
			final String value = entry.getValue().toString();
			
			stb.append("propriété : ");
			stb.append(key);
			stb.append('\t');
			stb.append("valeur : ");
			stb.append(value);
			stb.append('\n');
		}
		
		return stb.toString();
		
	} // Fin de afficherMapStringObject(...).______________________________
	

	
	/**
	 * <b>Fournit une String pour l'affichage d'un fichier</b>.
	 * <ul>
	 * <li>lit le fichier avec 
	 * <code>Files.readAllLines(pPath);</code></li>
	 * </ul>
	 * - retourne null si pPath == null.<br/>
	 * - retourne null si le fichier visé par pPath n'existe pas.<br/>
	 * - retourne null si le file visé par pPath est un répertoire.<br/> 
	 * <br/>
	 *
	 * @param pPath : Path : chemin du fichier à lire.<br/>
	 * 
	 * @return String.<br/>
	 * 
	 * @throws IOException
	 */
	public static String affichierFichier(
			final Path pPath) throws IOException {
		
		/* retourne null si pPath == null. */
		if (pPath == null) {
			return null;
		}
		
		final File file = pPath.toFile();
		
		/* retourne null si le fichier visé par pPath n'existe pas. */
		if (!file.exists()) {
			return null;
		}
		
		/* retourne null si le file visé par pPath est un répertoire. */
		if (file.isDirectory()) {
			return null;
		}
		
		final List<String> list = Files.readAllLines(pPath);
		
		final StringBuffer stb = new StringBuffer();
		
		for (final String ligne : list) {
			
			stb.append(ligne);
			stb.append(SAUT_LIGNE_PLATEFORME);
		}
		
		return stb.toString();
		
	} // Fin de affichierFichier(...)._____________________________________
	

	
} // FIN DE LA CLASSE JPAUtils.----------------------------------------------
