/**
 * CLASSE package-info :<br/>
 * Les <b>templates</b> sont des <b>bouts de code "tout faits"</b> 
 * comportant éventuellement des <b>variables</b>.<br/>
 * L'objectif est d'injecter ces bouts de code "tout faits" 
 * avec leurs éventuelles variables <i>substituées</i> 
 * dans le code que l'on développe.<br/>
 * <br/>
 * Les templates sont stockés sous forme de <b>fichiers .txt</b> 
 * dans les <i>ressources internes (sous le classpath)</i> de l'application.<br/>
 * <br/><br/>
 * <img src="../../../../../../../../../javadoc/images/gestionnairestemplates/gestion_templates.png" 
 * alt="Gestion des templates" border="1" align="center" />
 * <br/><br/>
 * 
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// chemin relatif du template par rapport aux ressources 
 * internes src/main/resources.</i></code><br/>
 * <b><code>final String cheminRelatifTemplate 
 * = "commentaires_properties/commentaires_labels_properties.txt"
 * ;</code></b><br/>
 * <code><i>// variable à substituer dans le template.</i></code><br/>
 * <b><code>final String variable = "{$Locale}";</code></b><br/>
 * <code><i>// valeur de substitution.</i></code><br/>
 * <b><code>final String substituant = localeCouranteFR.toString();
 * </code></b><br/>
 * <br/>	
 * <code><i>// Obtention du template substitué sous forme de String 
 * dans le code java auprès du Gestionaire de Templates.</i></code><br/>
 * <b><code>final String commentaire = 
 * gestionnaireTemplate.fournirTemplateSubstitueSousFormeString(
 * cheminRelatifTemplate, variable, substituant);</code></b><br/>
 * <br/>		
 * <code><i>// injection du template substitué dans le 
 * code java.</i></code><br/>
 * <b><code>gestionnairePropertiesCompletFR.
 * remplirEnDurFichierProperties(commentaire);</code></b><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * template, Template, liste de lignes à partir d'un fichier txt, <br/>
 * lire un fichier .txt, lire un fichier txt,<br/>
 * liste lignes à partir d'un fichier .txt, ListeLignes txt, <br/>
 * lire un template txt, lire un template .txt, obtenir liste lignes,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 15 juil. 2018
 *
 */
package levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates;
