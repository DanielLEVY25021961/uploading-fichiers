package levy.daniel.application.model.services.utilitaires.upload;

import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * INTERFACE IUploadService :<br/>
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
 * @since 10 nov. 2018
 *
 */
public interface IUploadService {

    
    
    /**
     * <p>nomme le fichier cible résultat d'un upload en concaténant 
     * la String pFilename à la racine des uploads et retourne son Path</p>
     * <ul>
     * <li>nommerFichierCible(inexistant) retourne un Path inexistant.</li>
     * <li>ne crée pas automatiquement l'arborescence et le fichier cible.</li>
     * </ul>
     * - retourne null si pFilename est blank.<br/>
     * <br/>
     *
     * @param pFilename : String : chemin <i>relatif</i> du fichier résultat 
     * de l'upload du fichier source par rapport à la racine des fichiers 
     * uploadés sur le serveur.
     * 
     * @return : Path : Path du fichier uploadé (cible) sur le serveur.<br/>
     * 
     * @throws Exception
     */
    Path nommerFichierCible(String pFilename) throws Exception;

    
    
    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     *
     * @param pFileSource : org.springframework.web.multipart.MultipartFile : 
     * le fichier multipart source à uploader.
     * 
     * @return File : java.io.File : le File uploadé. 
     * 
     * @throws Exception 
     */
    File uploadOneFile(MultipartFile pFileSource) throws Exception;


    
    /**
     * UPLOAD un fichier Multipart du <strong>client</strong> 
     * <code>org.springframework.web.multipart.MultipartFile</code> 
     * <i>pFileSource</i> 
     * vers un fichier <strong>destination</strong> 
     * <code>java.io.File </code> <i>pFileTarget</i>.<br/>
     * <ul>
     * <li>crée le fichier pFileTarget vide si il n'existait pas 
     * et recopie dedans le contenu de pFileSource.</li>
     * <li>écrase et remplace pFileTarget si il existait déjà.</li>
     * </ul>
     * <br/>
     * - n'uploade rien, LOG.fatal et jette une 
     * StorageFileNotFoundRunTimeException si pFileSource est null ou vide.<br/>
     * - n'uploade rien, LOG.fatal et jette une 
     * StorageFileNotFoundRunTimeException si pFileTarget est null
     * ou répertoire.</br>
     * <br/>
     *
     * @param pFileSource : org.springframework.web.multipart.MultipartFile : 
     * le fichier multipart source à uploader.
     * @param pFileTarget : java.io.File : le fichier cible uploadé.
     * 
     * @return File : java.io.File : le File uploadé.
     * 
     * @throws Exception
     */
    File uploadOneFile(MultipartFile pFileSource, File pFileTarget) throws Exception;
 
    
    
    /**
     * recherche tous les fichiers déjà uploadés côté serveur 
     * et retourne la collection sous forme de Stream&lt;Path&gt;.<br/>
     *
     * @return : Stream&lt;Path&gt;.<br/>
     * 
     * @throws Exception 
     */
    Stream<Path> loadAll() throws Exception;

    
    
    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     *
     * @param pFilename
     * @return :  :  .<br/>
     * 
     * @throws Exception
     */
    Resource loadAsResource(String pFilename) throws Exception;


    
    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     * :  :  .<br/>
     * 
     * @throws Exception
     */
    void deleteAll() throws Exception;

    
    
} // FIN DE L'INTERFACE IUploadService.-------------------------------------
