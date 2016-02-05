/*
   This file is part of MDE_Turf.

    MDE_Turf is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MDE_Turf is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with MDE_Turf.  If not, see <http://www.gnu.org/licenses/>.
  
 */

package MdeTurf;

public class MonAppli {
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args)
	    {
	      // Course:
	      // Nombre de partants , Type de course (P O M A)
	    	Course tc = new Course(13,'A');
	      
	      // Cheval:
          // Numéro , Cote , Age , Forme(classement) , Favori (Classement), Sexe (H,M, F) , Poids( pad en attelé), Dernière perf 	    
	        tc.addCheval(new Cheval( 1,  21, 0,  7,  6,'H', 0, "5"));
	        tc.addCheval(new Cheval( 2,   5, 0,  1,  4,'F', 0, "2"));
	        tc.addCheval(new Cheval( 3,  73, 0, 11, 13,'M', 0, "0"));
	        tc.addCheval(new Cheval( 4,  23, 0,  4,  7,'H', 0, "2"));
	        tc.addCheval(new Cheval( 5,  33, 0, 10,  9,'M', 0, "0"));
	        tc.addCheval(new Cheval( 6, 9.6, 0,  6,  5,'F', 0, "4"));
	        tc.addCheval(new Cheval( 7,   6, 0,  2,  2,'H', 0, "1"));
	        tc.addCheval(new Cheval( 8,  61, 0, 13, 12,'M', 0, "0"));
	        tc.addCheval(new Cheval( 9,  34, 0, 11, 10,'F', 0, "2"));
	        tc.addCheval(new Cheval(10,  75, 0, 12, 11,'H', 0, "7"));
	        tc.addCheval(new Cheval(11,  26, 0,  5,  8,'H', 0, "0"));
	        tc.addCheval(new Cheval(12,   4, 0,  3,  3,'H', 0, "2"));
	        tc.addCheval(new Cheval(13, 4.6, 0,  8,  1,'F', 0, "2"));
	        
	        // Création du pronostic pour la course
	        CopyOfProno Pcc = new CopyOfProno(tc);
	        // Calcul du pronostic 5 chevaux 
	        Pcc.calcule(5);
	        // Affichage des 5 premieres combinaisons dans l'odre du numéro du cheval
	        Pcc.affiche(5);
	        //  Affichage des 5 premieres combinaisons dans l'odre d'arrivée espéré
	        Pcc.afficheOrdre(5);
	    }
}

