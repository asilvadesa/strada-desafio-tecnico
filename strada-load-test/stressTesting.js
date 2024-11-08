import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
      { duration: '30s', target: 10 },
      { duration: '1m', target: 500 },
      { duration: '30s', target: 0 },
    ],
    thresholds: {
        http_req_failed: ['rate<0.05'], // http errors should be less than 5%
        http_req_duration: ['p(95)<3000'], // 95% of requests should be below 3000ms
      },
  };
  

  export default function () {
    const res = http.get('https://reqres.in/api/users?page=2');
    check(res, { 'status was 200': (r) => r.status == 200 });
    sleep(1);
  }