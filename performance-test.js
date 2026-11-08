import { check, sleep } from "k6";
import http from "k6/http";

// Configuración de Carga y Criterios de Calidad (Quality Gates)
export const options = {
  stages: [
    { duration: "10s", target: 10 }, // Rampa de subida a 10 usuarios virtuales
    { duration: "20s", target: 20 }, // Carga sostenida con 20 usuarios
    { duration: "10s", target: 0 }, // Rampa de bajada progresiva
  ],
  thresholds: {
    // Quality Gate 1: El 95% de las peticiones debe responder en menos de 500 ms
    http_req_duration: ["p(95)<500"],
    // Quality Gate 2: La tasa de error debe ser estrictamente menor al 1% (0.01)
    http_req_failed: ["rate<0.01"],
  },
};

export default function () {
  // Servidor oficial de pruebas de carga de Grafana k6
  const url = "https://test.k6.io";

  const res = http.get(url);

  // Verificaciones funcionales de respuesta
  check(res, {
    "status es 200": (r) => r.status === 200,
    "tiempo respuesta < 450ms": (r) => r.timings.duration < 450,
  });

  sleep(1);
}
