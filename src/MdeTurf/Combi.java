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

public class Combi implements Comparable<Object>{
    Cheval[] Chevaux;
    double Poids;
       
    public int compareTo(Object obj){
     Combi temp = (Combi) obj;
     if(temp.Poids == this.Poids)
         return 0;
     if(temp.Poids < this.Poids)
         return -1;
     return 1;
   }

    /** Creates a new instance of Combi */
    public Combi(int n)
    {
        this.Chevaux = new Cheval[n];
        this.Poids = 0;
    }
    
    public void  addCheval(int n, Cheval c)
    {
        this.Chevaux[n] = c;
    }
    
    public void  setPoids(double p)
    {
        this.Poids = p;
    }

}
