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

public class Cheval implements Comparable<Object>{
	  
    int Num;
    double Cote;
    double Age;
    int Forme;
    int Favori;
    char Sexe;
    double Poids;
    String DerPerf;
    double Valeur;
     
    public int compareTo(Object obj){
        Cheval temp = (Cheval) obj;
        if(temp.Valeur == this.Valeur)
            return 0;
        if(temp.Valeur < this.Valeur)
            return -1;
        return 1;
    }
    
    /** Creates a new instance of Cheval */
    public Cheval(int n, double c, double a, int f, int fv, char s, double p, String dp) {
        this.Num = n;
        this.Cote = c;
        this.Age = a;
        this.Forme = f;
        this.Favori = fv;
        this.Sexe = s;
        this.Poids = p;
        this.DerPerf = dp;
        this.Valeur = 0;
     
    }
}
