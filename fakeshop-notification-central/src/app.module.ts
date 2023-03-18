import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { ClientsModule, Transport } from '@nestjs/microservices';

@Module({
  imports: [ClientsModule.register([
    {
      name: 'any_name_i_want',
      transport: Transport.KAFKA,
      options: {
        client: {
          brokers: ['localhost:9092'],
        },
        consumer: {
          groupId: 'fake-shop',
        },
      },
    },
  ]),
  ],
  controllers: [AppController],
  providers: [],
})
export class AppModule { }
