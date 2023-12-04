<template>
  <div class="post">
    <div class="post-header">
      <img :src="post.author.avatar" alt="Author Avatar" class="avatar" />
      <div class="author-info">
        <h3>{{ post.author.name }}</h3>
        <p>{{ post.timestamp }}</p>
      </div>
    </div>
    <div class="post-content">
      <p>{{ post.content }}</p>
      <img v-if="post.image" :src="post.image" alt="Post Image" class="post-image" />
    </div>
    <div class="post-actions">
      <button @click="likePost" class="action-button">
        <i class="fas fa-thumbs-up"></i> {{ post.likes }} Likes
      </button>
      <button @click="commentPost" class="action-button">
        <i class="fas fa-comment"></i> {{ post.comments }} Comments
      </button>
      <button @click="sharePost" class="action-button">
        <i class="fas fa-share"></i> Share
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    post: {
      type: Object,
      required: true
    }
  },
  methods: {
    likePost() {
      // Handle like post logic
    },
    commentPost() {
      // Handle comment post logic
    },
    sharePost() {
      // Handle share post logic
    }
  }
};
</script>

<style scoped>
.post {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}

.post-header {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-right: 10px;
}

.author-info {
  display: flex;
  flex-direction: column;
}

.post-content {
  margin-bottom: 10px;
}

.post-image {
  width: 100%;
  max-height: 300px;
  object-fit: cover;
  margin-bottom: 10px;
}

.action-button {
  background-color: #f0f2f5;
  border: none;
  padding: 5px 10px;
  margin-right: 10px;
  cursor: pointer;
}

.action-button i {
  margin-right: 5px;
}
</style>
