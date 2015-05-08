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

package Turf;

import java.util.*;

public class CopyOfProno  {
	Course Course;
    int Jeu;
    int Nbcombine;
    java.util.LinkedList<Combi> Combinaisons;
   
// paramétrage de l'algorithme de calcul de la valeur de chaque cheval
// c'est ici qu'il faudra modifier pour affiner les performances de l'agorithme
    double[] valSexe   = { 22, 31, 25}; 
    double[] valForme  = { 44, 26, 41, 38, 40, 34, 36, 36, 23, 34, 24, 22, 29, 14, 29, 19, 13, 25, 10, 13};
    double[] valCote   = { 59, 60, 50, 39, 33, 24, 12};
    double[] valFavori = { 36, 33, 39, 42, 37, 36, 25, 32, 37, 31, 33, 27, 22, 28, 18, 16, 15, 18,  8, 20};
    double[] valPoids  = { 50,  0, 14, 100, 50, 75, 30, 33, 28, 46, 40, 34, 39, 39, 35, 32, 31, 33, 33, 22, 28, 19, 27, 24, 23, 13, 20,  0};
    double[][] valPerf = {{ 14, 33, 46, 28, 33, 33, 16, 17, 17, 33, 23, 19},
    		              { 14, 33, 46, 28, 33, 33, 16, 17, 17, 33, 23, 19},
    		              { 14, 33, 46, 28, 33, 33, 16, 17, 17, 33, 23, 19},
    		              { 14, 33, 46, 28, 33, 33, 16, 17, 17, 33, 23, 19}};
    
    
	public CopyOfProno(Course c)
    {
        this.Course = c;
        this.Combinaisons = new java.util.LinkedList<Combi>(); 
     }

// retourne la valeur en fonction de la form du cheval
	private double getValForme(int forme)
	{
		return valForme[forme];
	}
	
// retourne la valeur en fonction du sexe:
// F : femelle
// M : Male
// H : Hongre
	private double getValSexe(char sexe)
	{
		int i=0;
		
		switch (sexe)
		{
        	case 'F':  i=0; break;
        	case 'H':  i=1; break;
        	case 'M':  i=2; break;
		}
		       
		return valSexe[i];
	}
	
// retourne la valeur en fonction de la dernière perf
//0 : non classe
//1-9 : place
//T : tombe
//A : arrete
//D : disqualifie
	private double getValPerf(String perf)
	{
       double val = 0; 
       int i=0;
       
       switch (Course.Type)
		{
           case 'P':  i=0; break;
       	   case 'O':  i=1; break;
       	   case 'M':  i=2; break;
       	   case 'A':  i=3; break;
		}
		
	   if (perf == "0")	
	          val = valPerf[i][0];	
	   if (perf == "1")	
		      val = valPerf[i][1];
	   if (perf == "2")	
		      val = valPerf[i][2];
	   if (perf == "3")	
		      val = valPerf[i][3];
	   if (perf == "4")	
		      val = valPerf[i][4];
	   if (perf == "5")	
		      val = valPerf[i][5];
	   if (perf == "6")	
		      val = valPerf[i][6];
	   if (perf == "7")	
		      val = valPerf[i][7];
	   if (perf == "8")	
		      val = valPerf[i][8];
	   if (perf == "9")	
		      val = valPerf[i][9];
	   if (perf == "T")	
		      val = valPerf[i][10];
	   if (perf == "A")	
		      val = valPerf[i][11];
	   if (perf == "D")	
		      val = valPerf[i][12];
	  
	   return val;
	}
	
// on renvoi la valeur correspondant à l'ordre ddans les favoris de la presse
	private double getValFavori(int fav)
	{
		return valFavori[fav];
	}
	
// recherche de la valeur en fonction de la cote
	private double getValCote(double cote)
	{
		int i = 0;
		
		if ( cote >= 1 && cote <= 4)
			i =0;
		if ( cote > 4 && cote <= 6)
			i =1;
		if ( cote > 6 && cote < 10)
			i =2;
		if ( cote >= 10 && cote <= 14)
			i =3;
		if ( cote > 14 && cote <= 19)
			i =4;
		if ( cote > 19 && cote <= 29)
			i =5;
		if ( cote > 29 )
			i =6;
		
		return valCote[i];
	}
	
// recherche de la valeur en fonction du poids
	private double getValPoids(double poids)
	{
		int i = 0;
		
		if (poids < 61 || poids > 75.5) 
		{
			return 0;
		}
		else
		{ 
			i =(int)( (75.5 - poids) * 2 );
			return valPoids[i];	
		}
	}
	
// Calcul des combinaisons
	private void combine(int n, int p, int k, Course L, Course t, int r)
    {
    	  int i, j, j1;
    	  double val;
    	  Course t2 = new Course(n,this.Course.Type);
    	  
    	  if(r<p-k) return;
	
    	  if(k==p)
    	  {
    		  val = 0;
    		  Combi comb= new Combi(p);                 
    		  for(i=0;i<p;i++)
    		  {
    			  L.Chevaux[i].Valeur = getValForme(L.Chevaux[i].Forme) + getValSexe(L.Chevaux[i].Sexe) + getValPerf(L.Chevaux[i].DerPerf) + getValFavori(L.Chevaux[i].Favori)  + getValCote(L.Chevaux[i].Cote)+ getValPoids(L.Chevaux[i].Poids);
    			  comb.addCheval(i,L.Chevaux[i]);
    			  val = val + L.Chevaux[i].Valeur;
    		  }
    		  comb.setPoids(val);
    		  this.Combinaisons.add(comb);
    		  return;
    	  }
	
    	  for(i=0;i<r;i++)
    	  {
    		  L.Chevaux[k] = t.Chevaux[i];
    		  for(j=i+1, j1=0;j<r;j++, j1++)
    		  {
    			  t2.Chevaux[j1] = t.Chevaux[j];
    		  }
    		  combine(n, p, k+1, L, t2, j1);
    	  }
    }

// Calcul du pronostic
    @SuppressWarnings("unchecked")
	public void calcule(int j){
        this.Jeu = j;
        Course Lc = new Course(this.Course.nbChevaux,this.Course.Type); 
        combine(this.Course.nbChevaux, j, 0, Lc, this.Course,this.Course.nbChevaux);
        java.util.Collections.sort(Combinaisons);
     }
    
        
// Affichage des combinaisons dans l'ordre des numéro des chevaux
    public void affiche(int n )
    {
       	int i,j;
        Combi tmp = new Combi(this.Jeu);
        
        System.out.print(" ==> nb combinaisons :");
        System.out.print(this.Combinaisons.size());
        System.out.println();
        for(i=0;i<n;i++)
        {
            tmp = (Combi)this.Combinaisons.get(i);
            for(j=0;j<this.Jeu;j++)
            {
               System.out.print(tmp.Chevaux[j].Num);
               System.out.print("(");
               System.out.print(tmp.Chevaux[j].Valeur);
               System.out.print(")");
               System.out.print(" ");
            } 
            System.out.print(" ==> ");
            System.out.print(tmp.Poids);
            System.out.println();
        }
    }
    
// Affichage des combinaisons dans l'ordre des valeurs des chevaux    
    public void afficheOrdre(int n )
    {
    	int i,j;
        Combi tmp = new Combi(this.Jeu);
        
        Cheval[] tabChevaux = new Cheval[this.Jeu];
        
        System.out.print(" ==> nb combinaisons :");
        System.out.print(this.Combinaisons.size());
        System.out.println();
        for(i=0;i<n;i++)
        {
            tmp = (Combi)this.Combinaisons.get(i);
            System.arraycopy(tmp.Chevaux, 0, tabChevaux, 0, tmp.Chevaux.length);
            Arrays.sort(tabChevaux);
      
            for(j=0;j<this.Jeu;j++)
            {
               System.out.print(tabChevaux[j].Num);
               System.out.print("(");
               System.out.print(tabChevaux[j].Valeur);
               System.out.print(")");
               System.out.print(" ");
            } 
            System.out.print(" ==> ");
            System.out.print(tmp.Poids);
            System.out.println();
        }
    }
    
// recherche d'un combinaison particulière dans la liste des combinaisons       
    public static boolean testEgalite(Cheval[] t1,Cheval[] t2)
    {
       int i;
 
       for ( i = 0 ; i < t1.length ; i++ )
       {
          if ( t1[i] != t2[i] )
             return(false);
       }
       return(true);
    }
    
 
    public void recherche (Combi c)
    {
        int i,j,k;
        Combi tmp = new Combi(this.Jeu);
        
        k = 0;
        for(i=0;i<this.Combinaisons.size();i++)
        {
            tmp = (Combi)this.Combinaisons.get(i);
            if (testEgalite(tmp.Chevaux,c.Chevaux))k=i;
       
        }
        tmp = (Combi)this.Combinaisons.get(k);
        for(j=0;j<this.Jeu;j++)
        {
            System.out.print(tmp.Chevaux[j].Num);
            System.out.print(" ");
        } 
        System.out.print("trouv� en ");
        System.out.print(k+1);
        System.out.print(" avec un poids de ");
        System.out.print(tmp.Poids);
        System.out.println();
    }
}
