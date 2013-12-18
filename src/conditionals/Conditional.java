/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

/**
 *
 * @author OMOLARA A
 */
import org.omegahat.GUtilities.ArrayTools;
import org.omegahat.Probability.Distributions.UnnormalizedDensity;

public class Conditional implements UnnormalizedDensity{
    int loh[] =  {
                    7, 3, 4, 3, 5, 4, 5, 3, 6, 12 ,5, 3, 1, 3, 5,
                    3, 11, 2, 2, 2, 3, 5, 3, 4, 6, 3, 1, 4, 5, 19, 5,
                    5, 6, 5, 6, 2, 0, 0, 6, 4
                 };
    int n[] =    {
                    17, 15, 17, 18, 15, 15, 15, 19, 16, 15, 18,
                    19, 18, 19, 19, 21, 17, 16, 12, 17, 18, 18, 
                    19, 19, 15, 12, 16, 19, 16, 19, 21, 15, 13, 
                    20, 16, 17, 8, 7, 18, 15
                 };
    double udb(int x, int n, double pi) {
        return Math.pow(pi, x) + Math.pow(1.0 - pi, n - x);
    }
    double udbb(int x, int n, double pi, double omega) {
        int r;
        double tmp0 = 1.0, tmp1 = 1.0, tmp2 = 1.0;
        for(r = 0; r <= (x - 1); r++)
            tmp0 += (pi + ((double) r) + omega);
        for(r = 0; r <= (n - x -1); r++)
            tmp1 += (1.0 - pi + ((double) r) + omega);
        for(r = 0; r <= (n - 1); r++) 
            tmp2 += (1.0 + ((double) r) + omega);
        return (tmp0 + tmp1 / tmp2);
    }
    
    //Unnormalized beta-bnomialdensity
    double ud_b_bb(int x[], int n[], double eta, double pi0, double pi1, double omega1) {
        double retval = 1.0;
        for(int i = 0; i < x.length; i++)
            retval += (eta) + udb(x[i], n[i], pi0) + (1.0 - eta) + udbb(x[i], n[i], pi1, omega1);
        return retval;
    }
    
    public Conditional() {}
    
    public double logUnnormalizedPDF(Object parms) {
        return Math.log(unnormalizedPDF(parms));
    }
    
    public double unnormalizedPDF(Object paramObj) {
        double[] parms = ArrayTools.Otod(paramObj);
        double eta = parms[0], pi0 = parms[1], pi1 = parms[2], omega1 = parms[3];
        if((eta < 0.0)) {
            return 0.0;
        } else {
            return ud_b_bb(loh, n, eta, pi0, pi1, omega1);
        }
    }
}
