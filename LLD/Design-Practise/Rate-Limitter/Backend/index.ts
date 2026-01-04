import express, { Application, Request, Response } from 'express';
import cors from 'cors';
import { rateLimitterMiddleware } from './middleware/RateLimitter.middleware.ts';

const app: Application = express();
const port: number = 3000;

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(rateLimitterMiddleware) // -> RateLimitter is added here

app.post('/', (req: Request, res: Response) => {
    res.statusMessage = "Request Executed"
    res.status(200).send();
});

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
