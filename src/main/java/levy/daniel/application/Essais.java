package levy.daniel.application;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE Essais :<br/>
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
 * @since 30 oct. 2019
 *
 */
public class Essais {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(Essais.class);

	// *************************METHODES************************************/
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @param pArgs : String[] :  .<br/>
	 */
	public static void main(String... pArgs) {
		
//		final Integer resultatInteger = retournerEntierFixe();
//		System.out.println(resultatInteger);
		
//		afficherListePur();
		
//		afficherListeSansType();
		
//		afficherListeSansTypeSansCrochets();
		
		afficherListeAvecReferencesMethodes();
		
	} // Fin de main(...)._________________________________________________

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : int :  .<br/>
	 */
	public static Integer retournerEntierFixe() {
		Supplier<Integer> supplierInteger = () -> 12278;
		return supplierInteger.get();
	} // Fin de retournerEntierFixe()._____________________________________
	

	
	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	public static void afficherListePur() {
		
		final List<String> list 
			= Arrays.asList(
					new String[] {"EleMent1", "EleMEnt2", "Element3", "Element4"});
		
		final Stream<String> stream = list.stream();
		
		final Stream<String> streamToLowerCase 
			= stream.map(
					(String string) -> 
					{
						return string.toLowerCase();
					});
		
		streamToLowerCase.forEach(
				(String string) -> 
				{
					System.out.println(string); 
				});
		
	} // Fin de afficherListePur().________________________________________

	

	
	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	public static void afficherListeSansType() {
		
		final List<String> list 
			= Arrays.asList(
					new String[] {"EleMent1", "EleMEnt2", "Element3", "Element4"});
		
			list.stream()
				.map(string -> 
					{
						return string.toLowerCase();
					})	
				.map(string -> 
					{
					return string.toUpperCase();
					})		
				.forEach(string -> 
					{
						System.out.println(string); 
					});
		
	} // Fin de afficherListeSansType().___________________________________
	
	
	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	public static void afficherListeSansTypeSansCrochets() {
		
		final List<String> list 
			= Arrays.asList(
					new String[] {"EleMent1", "EleMEnt2", "Element3", "Element4"});
		
			list.stream()
				.map(string -> string.toLowerCase())	
				.map(string -> string.toUpperCase())		
				.forEach(string -> System.out.println(string));
		
	} // Fin de afficherListeSansTypeSansCrochets()._______________________
	
	
	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	public static void afficherListeAvecReferencesMethodes() {
		
		final List<String> list 
			= Arrays.asList(
					new String[] {"EleMent1", "EleMEnt2", "Element3", "Element4"});
		
			list.stream()
				.map(String::toLowerCase)	
				.map(String::toUpperCase)		
				.forEach(System.out::println);
		
	} // Fin de afficherListeAvecReferencesMethodes()._____________________

	
	
}
