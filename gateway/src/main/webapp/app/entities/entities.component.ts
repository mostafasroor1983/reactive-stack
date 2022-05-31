import { Component, Provide, Vue } from 'vue-property-decorator';

import UserService from '@/entities/user/user.service';
import PostService from './blog/post/post.service';
import TagService from './blog/tag/tag.service';
import ProductService from './store/product/product.service';
import BlogService from './blog/blog/blog.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

@Component
export default class Entities extends Vue {
  @Provide('userService') private userService = () => new UserService();
  @Provide('postService') private postService = () => new PostService();
  @Provide('tagService') private tagService = () => new TagService();
  @Provide('productService') private productService = () => new ProductService();
  @Provide('blogService') private blogService = () => new BlogService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
