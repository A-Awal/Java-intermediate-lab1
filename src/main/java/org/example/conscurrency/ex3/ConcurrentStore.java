package org.example.conscurrency.ex3;


public class ConcurrentStore {

        private static int sharedVariable;

        public synchronized int addToSharedVar(int addition){
            return ++ sharedVariable;
        }

}

