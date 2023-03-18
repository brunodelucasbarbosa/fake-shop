import { Controller } from '@nestjs/common';
import {
  Ctx,
  KafkaContext,
  MessagePattern,
  Payload,
} from '@nestjs/microservices';

@Controller()
export class AppController {
  constructor() { }

  @MessagePattern('fake-shop-login')
  readMessage(@Payload() message: any, @Ctx() context: KafkaContext) {
    const originalMessage = context.getMessage();
    const response =
      `Receiving a new message from topic: fake-shop-login: ` +
      JSON.stringify(originalMessage.value);
    console.log(response);
    console.log(`Message: ${message}`)
    return response;
  }
}
