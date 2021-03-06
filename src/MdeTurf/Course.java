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

public class Course {
	//P : Galop plat
	//O : Galop obstacle
	//M : Trot monté
	//A : Trot attelé
	char Type; 
	int nbChevaux;
    Cheval[] Chevaux;
    
    /** Creates a new instance of Course */
    public Course(int n, char t) 
    {
        this.nbChevaux = n;
        this.Chevaux = new Cheval[n];
    }
    
    public void addCheval(Cheval c)
    {
        this.Chevaux[c.Num-1]=c;     
    }
}
