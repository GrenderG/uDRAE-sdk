package dmoral.es.udrae_sdk.api.models;

import java.util.ArrayList;

/**
 * This file is part of uDRAE-SDK.
 * <p>
 * uDRAE-SDK is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p>
 * uDRAE-SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with uDRAE-SDK.  If not, see <http://www.gnu.org/licenses/>.
 */

public class BaseResponse {
    /**
     * Número de resultados que se aproximan a nuestra búsqueda, solo usado en algunos casos,
     * por ejemplo en búsquedas de definiciones
     */
    private int approx;
    /**
     * Lista de los resultados
     */
    private ArrayList<Res> res;

    public int getApprox() {
        return approx;
    }

    public void setApprox(int approx) {
        this.approx = approx;
    }

    public ArrayList<Res> getRes() {
        return res;
    }

    public void setRes(ArrayList<Res> res) {
        this.res = res;
    }

    public class Res {
        /**
         * Cabecera que se muestra en la definición de la palabra
         */
        private String header;
        /**
         * ID de la palabra (se usa para realizar búsquedas por ID, por ejemplo)
         */
        private String id;
        /**
         * En caso de haber varios resultados, grupo al que pertenece la palabra
         */
        private int grp;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getGrp() {
            return grp;
        }

        public void setGrp(int grp) {
            this.grp = grp;
        }
    }
}

