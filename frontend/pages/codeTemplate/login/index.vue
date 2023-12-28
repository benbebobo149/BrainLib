<script setup>
const startOAuth2Flow = () => {
    const clientId = '341589256904-2b8bl47v3ni78ft9f7ottqh3r6b63sf0.apps.googleusercontent.com';
    const redirectUri = 'http://localhost:3000/codeTemplate/oauth2';
    const scope = 'https://www.googleapis.com/auth/userinfo.email'; // 定义所需的范围

    // 构建OAuth 2.0认证URL
    const oauth2Url = `https://accounts.google.com/o/oauth2/auth?` +
        `client_id=${clientId}&` +
        `redirect_uri=${encodeURIComponent(redirectUri)}&` +
        `scope=${encodeURIComponent(scope)}&` +
        `response_type=token`;

    // 在新窗口中打开OAuth 2.0认证URL
    const authWindow = window.open(oauth2Url, 'OAuth2 Login', 'width=600,height=400');
    const checkUrlPrefix = setInterval(() => {
        try {
            const childUrl = authWindow.location.href;
            if (childUrl.startsWith('http://localhost:3000/codeTemplate/oauth2')) {
                clearInterval(checkUrlPrefix); // 停止定时器
                authWindow.close();
                window.location.href = childUrl; // 替换成您想要的跳转URL
            }
        } catch (error) {
            // 处理跨域安全性错误或其他错误
        }
    }, 500);
}

</script>

<template>
    <button @click="startOAuth2Flow()">
        Click me to login
    </button>
</template>
