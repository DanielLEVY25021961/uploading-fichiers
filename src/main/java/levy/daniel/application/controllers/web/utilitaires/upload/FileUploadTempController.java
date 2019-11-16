package levy.daniel.application.controllers.web.utilitaires.upload;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import levy.daniel.application.apptechnic.exceptions.technical.impl.StorageFileNotFoundRunTimeException;
import levy.daniel.application.model.services.utilitaires.upload.IUploadService;

/**
 * CLASSE FileUploadTempController :<br/>
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
@Controller(value="FileUploadTempController")
public class FileUploadTempController {

	// ************************ATTRIBUTS************************************/

    /**
     * Service chargé des UPLOADS.<br/>
     */
	@Qualifier(value="FileSystemUploadTempService")
    private final transient IUploadService uploadService;

 
	// *************************METHODES************************************/
	
     /**
     * CONSTRUCTEUR D'ARITE 1.<br/>
     * <ul>
     * <li>injection d'un UploadService par SPRING.</li>
     * </ul>
     *
     * @param pUploadService : IUploadService.
     */
    @Autowired(required=true)
    public FileUploadTempController(
    		final IUploadService pUploadService) {
        this.uploadService = pUploadService;
    } // Fin de CONSTRUCTEUR D'ARITE 1.____________________________________


    
	/**
	 * redirige vers la page d'accueil index.html.<br/>
	 *
	 * @return : String : "index".<br/>
	 */
	@GetMapping(value = "/")
	public String versAccueil() {
		return "index";
	} // Fin de versAccueil()._____________________________________________
    

	
	/**
	 * redirige vers la page d'upload d'un fichier unique 
	 * upload/uploadOneFile.html.
	 * <ul>
	 * <li>rafraîchit la liste des fichiers déjà uploadés 
	 * à chaque appel et l'insère dans pModel 
	 * dans l'attribut "fichiersDejaUploades".</li>
	 * </ul>
	 * 
	 * @param pModel : org.springframework.ui.Model
	 *
	 * @return : String : "upload/uploadOneFile".<br/>
	 * 
	 * @throws Exception 
	 */
	@GetMapping(value = "/versUploadOneFile")
	public String versUploadOneFile(final Model pModel) throws Exception {
		
		System.out.println("***** DANS versUploadOneFile(...) **************");
		
		/* rafraîchissement de la liste. */
		this.rafraichirListeFichiersDejaUploades(pModel);
		
		return "upload/uploadOneFile";
		
	} // Fin de versUploadOneFile()._______________________________________
	
	
	
    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     *
     * @param pFile
     * @param redirectAttributes
     * @return :  :  .<br/>
     * @throws Exception 
     */
    @PostMapping("/uploadOneFile")
    public String uploadOneFile(
	    	@RequestParam("fichierAUploader") final MultipartFile pFile
    			, final RedirectAttributes redirectAttributes) throws Exception {
    	
        final File resultat = this.uploadService.uploadOneFile(pFile);
        
        final String message = pFile.getOriginalFilename() 
                + " a bien été uploadé côté serveur à l'emplacement : " 
        		+ resultat.getAbsolutePath();
        
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/versUploadOneFile";
        
    } // Fin de uploadOneFile(...).________________________________________


	
    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     *
     * @param pModel
     * @return String
     * @throws Exception 
     */
    @GetMapping("/listUploadedFiles")
    public String listUploadedFiles(
    		final Model pModel) throws Exception {

    	System.out.println("***** DANS listUploadedFiles(...) **************");
    	
        pModel.addAttribute("fichiersDejaUploades", this.uploadService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadTempController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }
    
 
	
	/**
	 * rafraîchit la liste des fichiers déjà uploadés 
	 * et l'insère dans pModel dans l'attribut "fichiersDejaUploades".
	 *
	 * @param pModel : org.springframework.ui.Model
	 * @throws Exception 
	 */
	private void rafraichirListeFichiersDejaUploades(
							final Model pModel) throws Exception {
		
		System.out.println("***** DANS rafraichirListeFichiersDejaUploades(...) **************");
				
//		pModel.addAttribute(
//				"fichiersDejaUploades", this.uploadService.loadAll()
//				.map(path -> MvcUriComponentsBuilder
//                		.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
//                		.build().encode().toString())
//                		.collect(Collectors.toList()));

//		Map<String, String> fichiersDejaUploadesMap = new HashMap<String, String>();
		
		final Stream<Path> streamPath = this.uploadService.loadAll();
				
		final Map<String, String> fichiersDejaUploadesMap 
			= streamPath
				.collect(Collectors.toMap(
						path -> MvcUriComponentsBuilder
		            	.fromMethodName(FileUploadTempController.class, "serveFile", path.getFileName().toString())
		            	.build().encode().toString()
						, path -> path.getFileName().toString()));
		
		pModel.addAttribute(
				"fichiersDejaUploadesMap", fichiersDejaUploadesMap);
		
	} // Fin de rafraichirListeFichiersDejaUploades(...).__________________
    
    

    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     *
     * @param pFilename
     * @return :  :  .<br/>
     * @throws Exception 
     */
    @GetMapping("/televersements/originaux/{pFilename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(
    		@PathVariable final String pFilename) throws Exception {

    	System.out.println("***** DANS serveFile(...) **************");
    	System.out.println("serveFile pFilename : " + pFilename);
    	
        final Resource file 
        	= this.uploadService.loadAsResource(pFilename);
        
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    

    /**
     * .<br/>
     * <ul>
     * <li>.</li>
     * </ul>
     *
     * @param pExc
     * @return :  :  .<br/>
     */
    @ExceptionHandler(StorageFileNotFoundRunTimeException.class)
    public ResponseEntity<?> handleStorageFileNotFound(
    		final StorageFileNotFoundRunTimeException pExc) {
        return ResponseEntity.notFound().build();
    }

    
    
}
