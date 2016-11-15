package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Luke on 10/21/2016.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<Crime>();
        //Temporary list generation
       /*for(int i = 0; i < 100; i++) {
            Crime myCrime = new Crime();
            myCrime.setTitle("Crime #"+i);
            myCrime.setSolved(i%2 == 0);
            mCrimes.add(myCrime);
        }*/
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public void deleteCrime(Crime c) {
        mCrimes.remove(c);
    }

    //Alternative method to delete crime by UUID. Probably will never be used.
    public void deleteCrime(UUID uuid) {
        mCrimes.remove(getCrime(uuid));
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if(crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

    public int getIndexOf(Crime crime) {
        return mCrimes.indexOf(crime);
    }
}
